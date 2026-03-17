package ru.greenlight.springmvchibernate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.greenlight.springmvchibernate.models.User;
import ru.greenlight.springmvchibernate.service.UserService;

@Controller
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getUsersByCount(@RequestParam(value = "id", required = false) Integer id, Model model) {

//        userService.addUsers();

        if (id != null) {
            if (id < 0 || id == 0) {
                model.addAttribute("error", "Ошибка: значение id не может быть 0 или отрицательным.");
            } else {
                model.addAttribute("user", userService.showUserById(id));
                return "user";
            }
        } else {
            model.addAttribute("users", userService.showAllUsers());
        }

        return "users";
    }

    @GetMapping("/users/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping("/users")
    public String addUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }
}
