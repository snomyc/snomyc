package com.snomyc.sys.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.snomyc.sys.bean.LotterDraw;

@Repository
public interface LotterDrawDao extends JpaRepository<LotterDraw, String> {
}