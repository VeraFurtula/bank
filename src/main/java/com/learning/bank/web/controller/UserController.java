package com.learning.bank.web.controller;
import com.learning.bank.model.Account;
import com.learning.bank.model.User;
import com.learning.bank.service.AccountService;
import com.learning.bank.service.UserService;
import com.learning.bank.support.AccountToAccountDto;
import com.learning.bank.support.UserDtoToUser;
import com.learning.bank.support.UserToUserDto;
import com.learning.bank.web.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private UserDtoToUser toUser;

    @Autowired
    private UserToUserDto toUserDto;

    @Autowired
    private AccountToAccountDto toAccountDto;

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("user", new UserDTO());
        return "userForm";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("user") UserDTO userDTO, Model model) {
        User user = toUser.convert(userDTO);
        User savedUser = userService.save(user);
        model.addAttribute("user", toUserDto.convert(savedUser));
        return "userDetail";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        User user = userService.findOne(id);
        if (user != null) {
            model.addAttribute("user", toUserDto.convert(user));
            return "userForm";
        }
        return "error";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @Valid @ModelAttribute("user") UserDTO userDTO, Model model) {
        if (!id.equals(userDTO.getId())) {
            return "error";
        }
        User user = toUser.convert(userDTO);
        User savedUser = userService.update(user);
        model.addAttribute("user", toUserDto.convert(savedUser));
        return "userDetail";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id, Model model) {
        User deletedUser = userService.delete(id);
        if (deletedUser != null) {
            return "redirect:/users";
        }
        model.addAttribute("error", "User not found");
        return "error";
    }

    @GetMapping("/{id}")
    public String getOne(@PathVariable Long id, Model model) {
        User user = userService.findOne(id);
        if (user != null) {
            model.addAttribute("user", toUserDto.convert(user));
            return "userDetail";
        }
        model.addAttribute("error", "User not found");
        return "error";
    }

    @GetMapping
    public String getAllUsers(Model model) {
        List<UserDTO> users = toUserDto.convert(userService.findAll());
        model.addAttribute("users", users);
        return "userList";
    }

    @GetMapping("/{id}/accounts")
    public String findAccountsByUserId(@PathVariable @Positive(message = "ID must be positive.") Long id, Model model) {
        List<Account> accounts = accountService.findByAccountId(id);
        model.addAttribute("projections", toAccountDto.convert(accounts));
        return "accountList";
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public String handleDataIntegrityViolation(Model model) {
        model.addAttribute("error", "Data integrity violation occurred.");
        return "error";
    }

}
