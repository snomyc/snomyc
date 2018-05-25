package com.snomyc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.snomyc.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User findById(String id);
}