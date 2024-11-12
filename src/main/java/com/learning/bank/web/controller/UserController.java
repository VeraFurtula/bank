package com.learning.bank.web.controller;

import com.learning.bank.dto.UserDto;
import com.learning.bank.service.UserService;
import com.learning.bank.dto.UserCreateDto;
import com.learning.bank.dto.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getAllUsers(Model model) {
        List<UserResponseDto> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "user-list";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable Long id, Model model) {
        UserResponseDto user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "user-details";
    }

    @GetMapping("/new")
    public String showCreateUserForm() {
        return "user-create-form";
    }

    @PostMapping("/new")
    public String createUser(@ModelAttribute("users") UserCreateDto userCreateDto) {
        userService.createUser(userCreateDto);
        return "redirect:/users"; // Preusmerava na listu korisnika nakon uspešnog kreiranja
    }

    @GetMapping("/edit/{id}")
    public String showEditUserForm(@PathVariable Long id, Model model) {
        UserResponseDto user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "user-form";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute("user") UserCreateDto userUpdateDto) {
        userService.updateUser(id, userUpdateDto);
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}