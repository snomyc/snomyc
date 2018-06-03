package com.snomyc.sys.config.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.snomyc.sys.config.bean.SysConfig;

public interface SysConfigDao extends JpaRepository<SysConfig, String> {

}
