package com.snomyc.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import com.snomyc.base.service.BaseServiceImpl;
import com.snomyc.sys.bean.LotterDraw;
import com.snomyc.sys.dao.LotterDrawDao;
import com.snomyc.sys.service.LotterDrawService;

@Service
public class LotterDrawServiceImpl extends BaseServiceImpl<LotterDraw, String> implements LotterDrawService{

    @Autowired
    private LotterDrawDao lotterDrawDao;

	@Override
	public PagingAndSortingRepository<LotterDraw, String> getDao() {
		return lotterDrawDao;
	}

}


