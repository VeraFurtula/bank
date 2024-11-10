package com.learning.bank.web.controller;

import com.learning.bank.service.AccountService;
import com.learning.bank.dto.AccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/test")
    public String showTestPage() {
        return "testPage"; // Vraća testPage.html
    }

    @GetMapping
    public String listAccounts(Model model) {
        model.addAttribute("accounts", accountService.findAll());
        return "account-list"; // Thymeleaf šablon za listu računa
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("account", new AccountDto());
        return "account-form"; // Thymeleaf šablon za kreiranje računa
    }

    @PostMapping("/save")
    public String saveAccount(@Valid @ModelAttribute("account") AccountDto accountDto, BindingResult result) {
        if (result.hasErrors()) {
            return "account-form";
        }
        accountService.save(accountDto);
        return "redirect:/accounts";
    }
}