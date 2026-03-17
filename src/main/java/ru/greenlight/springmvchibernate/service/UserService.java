package ru.greenlight.springmvchibernate.service;

import ru.greenlight.springmvchibernate.models.User;

import java.util.List;

public interface UserService {

    void addUsers();

    List<User> showAllUsers();

    User showUserById(int id);
}
