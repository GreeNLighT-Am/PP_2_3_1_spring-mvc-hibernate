package ru.greenlight.springmvchibernate.dao;

import ru.greenlight.springmvchibernate.models.User;

import java.util.List;

public interface UserDao {

    void addUser(User user);

    List<User> showAllUsers();

    User showUserById(int id);

    void updateUser(User updatedUser);

    void deleteUserById(int id);

}
