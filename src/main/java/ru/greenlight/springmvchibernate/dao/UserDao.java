package ru.greenlight.springmvchibernate.dao;

import ru.greenlight.springmvchibernate.models.User;

import java.util.List;

public interface UserDao {
    void addUsers();

    List<User> getAllUsers();

    List<User> getUsersByCount(List<User> users, int count);
}
