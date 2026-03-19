package ru.greenlight.springmvchibernate.dao;

import ru.greenlight.springmvchibernate.models.User;

import java.util.List;

public interface UserDao {

    void addUser(User user);

    List<User> showAllUsers();

    User showUserById(int id);

    void updateUserById(int id, User updatedUser);

    void deleteUserById(int id);
}
