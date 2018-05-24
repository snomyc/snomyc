package com.snomyc.service;

import java.util.List;
import com.snomyc.entity.User;

public interface UserService {

    public List<User> getUserList();

    public User findUserById(long id);

    public void save(User user);

    public void edit(User user);

    public void delete(long id);


}
