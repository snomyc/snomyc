package com.snomyc.sys.service;

import com.snomyc.api.user.request.UserEditRequest;
import com.snomyc.base.service.BaseService;
import com.snomyc.sys.bean.User;

import java.util.List;

public interface UserService extends BaseService<User, String>{

    public User findUserById(String id);

    List<User> findByIds(String id);

    public void testSave(UserEditRequest request);

    public void testTranSactional(UserEditRequest request);
}
