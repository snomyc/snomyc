package com.snomyc.sys.service.impl;

import java.net.URLEncoder;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.snomyc.base.service.BaseServiceImpl;
import com.snomyc.sys.bean.AmazonKeyWord;
import com.snomyc.sys.dao.AmazonKeyWordDao;
import com.snomyc.sys.service.AmazonKeyWordService;
import com.snomyc.sys.service.SysConfigService;
import com.snomyc.util.HttpClientHelper;

@Service
public class AmazonKeyWordServiceImpl extends BaseServiceImpl<AmazonKeyWord, String> implements AmazonKeyWordService{

    @Autowired
    private AmazonKeyWordDao amazonKeyWordDao;
    
    @Autowired
    private SysConfigService sysConfigService;

	@Override
	public PagingAndSortingRepository<AmazonKeyWord, String> getDao() {
		return amazonKeyWordDao;
	}

	@Override
	public List<AmazonKeyWord> findByKeyWordRoot(String keyWordRoot) {
		List<AmazonKeyWord> list = amazonKeyWordDao.findByKeyWordRoot(keyWordRoot);
		//如果数据库种存在该记录，那么就不去网站上爬取
		if(CollectionUtils.isNotEmpty(list)) {
			return list;
		}
		this.saveListByKeyWordRoot(keyWordRoot);
		//通过关键词根词查询关键词集合
		return amazonKeyWordDao.findByKeyWordRoot(keyWordRoot);
	}
	
	private void saveListByKeyWordRoot(String keyWordRoot) {
		//通过词根 爬取亚马逊搜索接口 获取关键词集合 并入库
		String searchUrl = sysConfigService.findParamValByCode("AMAZON_SEARCH");
		//转义关键词 拼接查询条件
		String url = searchUrl + URLEncoder.encode(keyWordRoot);
		String result = HttpClientHelper.httpGet(url);
		this.saveByHttpGetResult(keyWordRoot, result);
		//通过词根+空格+(a-z)获取关键词集合并入库，去重
		for (int i = 'a'; i <= 'z'; i++) {
			String keyWordRootAdd = keyWordRoot + " "+i;
			url =  searchUrl + URLEncoder.encode(keyWordRootAdd);
			result = HttpClientHelper.httpGet(url);
			this.saveByHttpGetResult(keyWordRoot, result);
		}
	}
	
	private void saveByHttpGetResult(String keyWordRoot,String result) {
		if(StringUtils.isNotBlank(result)) {
			//转成json格式,并获取数组第二条记录
			JSONArray arrayList = JSONArray.parseArray(result).getJSONArray(1);
			System.out.println(arrayList);
			Iterator<Object> it = arrayList.iterator();
			while (it.hasNext()) {
				try {
					String keyWordSecond = (String) it.next();
					//将关键词入库
					AmazonKeyWord KeyWord = new AmazonKeyWord();
					KeyWord.setKeyWordRoot(keyWordRoot);
					KeyWord.setKeyWordSecond(keyWordSecond);
					KeyWord.setCreateTime(new Date());
					amazonKeyWordDao.save(KeyWord);
				}catch (Exception e) {
					//因为keyWordSecond唯一，防止数据库中有该值导致爆粗，故捕获异常
				}
			}
		}
	}

	@Override
	public List<AmazonKeyWord> findListByKeyWordRoot(String keyWordRoot) {
		return amazonKeyWordDao.findByKeyWordRoot(keyWordRoot);
	}

	@Override
	public void updateKeyWord(String keyWordRoot) {
		//删除数据库种已存在的关键词词根集合
		List<AmazonKeyWord> list = amazonKeyWordDao.findByKeyWordRoot(keyWordRoot);
		amazonKeyWordDao.delete(list);
		this.saveListByKeyWordRoot(keyWordRoot);
	}

}


