package com.snomyc.sys.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.snomyc.sys.bean.User;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, String> {

    User findById(String id);

    @Query(value="select * from user where id = ?1", nativeQuery = true)
    List<User> findByIds(String id);
}