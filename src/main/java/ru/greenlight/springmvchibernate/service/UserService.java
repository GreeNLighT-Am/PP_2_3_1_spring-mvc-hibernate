package ru.greenlight.springmvchibernate.service;

import ru.greenlight.springmvchibernate.models.User;

import java.util.List;

public interface UserService {

    void addUsers();

    List<User> getAllUsers();

    List<User> getUsersByCount(List<User> users, int count);
}
