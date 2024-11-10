package com.learning.bank.web.controller;

import com.learning.bank.service.UserService;
import com.learning.bank.dto.UserCreateDto;
import com.learning.bank.dto.UserUpdateDto;
import com.learning.bank.dto.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;
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
    public String listUsers(Model model) {
        List<UserResponseDto> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "user-list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("user", new UserCreateDto());
        return "user-form";
    }

    @PostMapping("/save")
    public String saveUser(@Valid @ModelAttribute("user") UserCreateDto userCreateDto, BindingResult result,
                           RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "user-form";
        }
        userService.createUser(userCreateDto);
        redirectAttributes.addFlashAttribute("message", "User created successfully!");
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        UserResponseDto user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "user-form";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") Long id, @Valid @ModelAttribute("user") UserUpdateDto userUpdateDto,
                             BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "user-form";
        }
        userService.updateUser(id, userUpdateDto);
        redirectAttributes.addFlashAttribute("message", "User updated successfully!");
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        userService.deleteUser(id);
        redirectAttributes.addFlashAttribute("message", "User deleted successfully!");
        return "redirect:/users";
    }
}