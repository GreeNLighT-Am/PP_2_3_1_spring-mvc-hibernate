package ru.greenlight.springmvchibernate.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.greenlight.springmvchibernate.models.User;
import ru.greenlight.springmvchibernate.service.UserService;

@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String showUsers(@RequestParam(value = "id", required = false) Integer id, Model model) {

        if (id != null) {
            if (id < 0 || id == 0) {
                model.addAttribute("error", "Ошибка: значение id не может быть 0 или отрицательным.");
            } else {
                model.addAttribute("user", userService.showUserById(id));
                return "users/user";
            }
        } else {
            model.addAttribute("users", userService.showAllUsers());
        }

        return "users/users";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "users/new";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute("user") @Valid User user, BindingResult userBindingResult) {
        if (userBindingResult.hasErrors()) {
            return "users/new";
        }
        userService.addUser(user);
        return "users/user";
    }

    @GetMapping("/edit")
    public String editUser(@RequestParam(value = "id", required = false) Integer id, Model model) {
        model.addAttribute("user", userService.showUserById(id));
        return "users/edit";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") @Valid User user, BindingResult userBindingResult,
                             @RequestParam(value = "id", required = false) Integer id) {
        if (userBindingResult.hasErrors()) {
            return "users/edit";
        }
        userService.updateUserById(id, user);
        return "users/user";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam(value = "id", required = false) Integer id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }

}
