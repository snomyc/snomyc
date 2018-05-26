package com.snomyc.sys.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import com.snomyc.base.service.BaseServiceImpl;
import com.snomyc.sys.user.bean.User;
import com.snomyc.sys.user.dao.UserDao;
import com.snomyc.sys.user.service.UserService;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, String> implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public User findUserById(String id) {
        return userDao.findById(id);
    }

	@Override
	public PagingAndSortingRepository<User, String> getDao() {
		return userDao;
	}

}


