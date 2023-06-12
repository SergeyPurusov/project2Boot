package ru.purusov.spring.project2Boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.purusov.spring.project2Boot.model.User;
import ru.purusov.spring.project2Boot.service.UserService;

@Controller
@RequestMapping("/")
public class MyController {
    private final UserService userService;

    public MyController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String print(ModelMap model) {
        model.addAttribute("users", userService.getAllUsers());
        return "infoUser";
    }

    @GetMapping(value = "/users")
    public String printUsers(ModelMap model) {
        model.addAttribute("users", userService.getAllUsers());
        return "infoUser";
    }

    @GetMapping(value = "/new")
    public String newUser(ModelMap model) {
        model.addAttribute("user", new User());
        return "allUsers";
    }

    @PostMapping(value = "/users")
    public String saveNewUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping(value = "/{id}/edit")
    public String edit(ModelMap model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getUserById(id));
        return "allUsers";
    }

    @PostMapping(value = "/users/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") long id) {
        userService.updateUser(user);
        return "redirect:/users";
    }



    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.removeUser(id);
        return "redirect:/users";
    }
}