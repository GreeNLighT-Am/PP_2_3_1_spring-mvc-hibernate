package ru.greenlight.springmvchibernate.dao;

import org.springframework.stereotype.Repository;
import ru.greenlight.springmvchibernate.models.User;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public List<User> getAllUsers() {
        return List.of(
                new User("Mike", 33, "mikle@gmail.com"),
                new User("John", 45, "dearjohn@gmail.com"),
                new User("Vasya", 23, "vasyanvasyanich@mail.ru"),
                new User("Jackson", 22, "jackasson@hotmail.com"),
                new User("Greg", 34, "gregory@gmail.com")
        );
    }

    @Override
    public List<User> getUsersByCount(List<User> users, int count) {
        return users.stream()
                .limit(count)
                .collect(Collectors.toList());
    }
}
