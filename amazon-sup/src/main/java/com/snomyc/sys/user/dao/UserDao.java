package com.snomyc.sys.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.snomyc.sys.user.bean.User;

@Repository
public interface UserDao extends JpaRepository<User, String> {

    User findById(String id);
}