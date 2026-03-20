package ru.greenlight.springmvchibernate.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.greenlight.springmvchibernate.dao.UserDao;
import ru.greenlight.springmvchibernate.models.User;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public List<User> showAllUsers() {
        return userDao.showAllUsers();
    }

    @Override
    public User showUserById(int id) {
        return userDao.showUserById(id);
    }

    @Override
    public void updateUser(User updatedUser) {
        userDao.updateUser(updatedUser);
    }

    @Override
    public void deleteUserById(int id) {
        userDao.deleteUserById(id);
    }

}
