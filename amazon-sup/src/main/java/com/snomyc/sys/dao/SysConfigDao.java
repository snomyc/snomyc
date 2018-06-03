package com.snomyc.sys.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.snomyc.sys.bean.SysConfig;


public interface SysConfigDao extends JpaRepository<SysConfig, String> {

}
