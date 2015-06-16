package com.example.spring.shjconf.service;

import com.example.spring.shjconf.dao.CRUD;
import com.example.spring.shjconf.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Work with DAO/CRUD and some business logic
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private CRUD crud;

    @Override
    public void addUser(User user) {
        crud.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return crud.getAll(User.class);
    }

    @Override
    public void deleteUser(long id) {
        crud.delete(crud.get(User.class, id));
    }
}
