package ru.greenlight.springmvchibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.greenlight.springmvchibernate.dao.UserDao;
import ru.greenlight.springmvchibernate.models.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao, UserDao userDao1) {
        this.userDao = userDao1;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public List<User> getUsersByCount(List<User> users, int count) {
        return userDao.getUsersByCount(users, count);
    }
}
