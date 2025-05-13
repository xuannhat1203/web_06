package com.baitap.session06.service;

import com.baitap.session06.dao.UserDao;
import com.baitap.session06.dao.UserDaoImp;
import com.baitap.session06.modal.User;

public class UserServiceImp implements UserService {
    public UserDao userDao;
    public UserServiceImp() {
        userDao = new UserDaoImp();
    }
    @Override
    public User getUserById(String username, String password) {
        return userDao.getUserById(username, password);
    }

    @Override
    public boolean addUser(User user) {
        return userDao.addUser(user);
    }
}
