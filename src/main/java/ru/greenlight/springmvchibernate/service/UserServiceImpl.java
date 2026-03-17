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
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUsers() {
        userDao.addUsers();
    }

    @Override
    public List<User> showAllUsers() {
        return userDao.showAllUsers();
    }

    @Override
    public User showUserById(int id) {
        return userDao.showUserById(id);
    }
}
