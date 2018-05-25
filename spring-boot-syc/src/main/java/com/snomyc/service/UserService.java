package com.snomyc.service;

import com.snomyc.base.service.BaseService;
import com.snomyc.entity.User;
public interface UserService extends BaseService<User, String>{

    public User findUserById(String id);
}
