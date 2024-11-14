package com.learning.bank.web.controller;
import com.learning.bank.model.Account;
import com.learning.bank.service.AccountService;
import com.learning.bank.service.UserService;
import com.learning.bank.support.AccountDtoToAccount;
import com.learning.bank.support.AccountToAccountDto;
import com.learning.bank.web.dto.AccountDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountDtoToAccount toAccount;

    @Autowired
    private AccountToAccountDto toAccountDto;

    @PostMapping("/create")
    public String createAccount(@ModelAttribute("account") @Valid AccountDTO accountDTO, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("users", userService.findAll());
            return "accountForm";
        }
        Account account = toAccount.convert(accountDTO);
        accountService.save(account);
        return "redirect:/accounts";
    }


    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("account", new AccountDTO());
        model.addAttribute("users", userService.findAll());
        return "accountForm";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Account account = accountService.findOne(id);
        if (account == null) {
            return "redirect:/accounts";
        }
        AccountDTO accountDTO = toAccountDto.convert(account);
        model.addAttribute("account", accountDTO);
        model.addAttribute("users", userService.findAll()); // Lista korisnika za izbor
        return "accountForm";
    }

    @PostMapping("/update/{id}")
    public String updateAccount(@PathVariable Long id, @ModelAttribute("account") @Valid AccountDTO accountDTO, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("users", userService.findAll());
            return "accountForm";
        }
        accountDTO.setId(id);
        Account account = toAccount.convert(accountDTO);
        accountService.update(account);
        return "redirect:/accounts";
    }

    @PostMapping("/update")
    public String updateAccount(@Valid @ModelAttribute AccountDTO accountDTO, Model model) {
        if (accountDTO.getId() == null) {
            model.addAttribute("error", "ID is required for updating an account.");
            return "error";
        }

        Account account = toAccount.convert(accountDTO);
        if (account == null || account.getUser() == null) {
            model.addAttribute("error", "Invalid account data");
            return "error";
        }

        Account updatedAccount = accountService.update(account);
        if (updatedAccount == null) {
            model.addAttribute("error", "Failed to update account");
            return "error";
        }

        model.addAttribute("account", toAccountDto.convert(updatedAccount));
        return "accountDetail";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        Account deletedAccount = accountService.delete(id);

        if (deletedAccount != null) {
            return "redirect:/accounts";
        } else {
            model.addAttribute("error", "Account is not found");
            return "error";
        }
    }

    @GetMapping("/details/{id}")
    public String getOne(@PathVariable Long id, Model model) {
        Account account = accountService.findOne(id);

        if (account != null) {
            model.addAttribute("account", toAccountDto.convert(account));
            return "accountDetail";
        } else {
            model.addAttribute("error", "Account is not found");
            return "error";
        }
    }

    @GetMapping
    public String getAllAccounts(Model model) {
        List<Account> accounts = accountService.findAll();
        model.addAttribute("accounts", accounts);

        return "accountList";
    }
}
