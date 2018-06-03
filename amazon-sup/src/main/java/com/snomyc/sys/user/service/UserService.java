package com.snomyc.sys.user.service;

import com.snomyc.base.service.BaseService;
import com.snomyc.sys.user.bean.User;
public interface UserService extends BaseService<User, String>{

    public User findUserById(String id);
}
