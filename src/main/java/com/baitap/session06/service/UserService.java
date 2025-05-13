package com.baitap.session06.service;

import com.baitap.session06.modal.User;

public interface UserService {
    User getUserById(String username, String password);
    boolean addUser(User user);
}
