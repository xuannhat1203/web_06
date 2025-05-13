package com.baitap.session06.dao;

import com.baitap.session06.modal.User;

public interface UserDao {
    User getUserById(String username, String password);
    boolean addUser(User user);
}
