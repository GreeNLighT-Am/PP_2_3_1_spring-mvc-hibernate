package ru.greenlight.springmvchibernate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.greenlight.springmvchibernate.models.User;
import ru.greenlight.springmvchibernate.service.UserService;

import java.util.List;

@Controller
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getUsers(@RequestParam(value = "count", required = false) Integer count, ModelMap model) {

//        userService.addUsers();

        List<User> users = userService.getAllUsers();

        if (count != null) {
            if (count < 0 || count == 0) {
                model.addAttribute("error", "Ошибка: значение count не может быть 0 или отрицательным.");
            } else {
                model.addAttribute("users", userService.getUsersByCount(users, count));
            }
        } else {
            model.addAttribute("users", users);
        }

        return "users";
    }

}
