package com.example.spring.shjconf.service;

import com.example.spring.shjconf.model.User;

import java.util.List;

/**
 * Business logic
 */
public interface UserService {
    void addUser(User page);

    void deleteUser(long id);

    List<User> getAllUsers();
}
