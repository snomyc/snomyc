package com.snomyc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import com.snomyc.base.service.BaseServiceImpl;
import com.snomyc.entity.User;
import com.snomyc.repository.UserRepository;
import com.snomyc.service.UserService;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, String> implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUserById(String id) {
        return userRepository.findById(id);
    }

	@Override
	public PagingAndSortingRepository<User, String> getDao() {
		return userRepository;
	}

}


