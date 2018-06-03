package com.snomyc.sys.config.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import com.snomyc.base.service.BaseServiceImpl;
import com.snomyc.sys.config.bean.SysConfig;
import com.snomyc.sys.config.dao.SysConfigDao;
import com.snomyc.sys.config.service.SysConfigService;
@Service
public class SysConfigServiceImpl extends BaseServiceImpl<SysConfig, String> implements SysConfigService{

    @Autowired
    private SysConfigDao sysConfigDao;
    
    @Override
	public PagingAndSortingRepository<SysConfig, String> getDao() {
		return sysConfigDao;
	}

	
}


