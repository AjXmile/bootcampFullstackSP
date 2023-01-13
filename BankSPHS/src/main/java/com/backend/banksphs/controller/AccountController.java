package com.backend.banksphs.controller;

import com.backend.banksphs.entity.Account;
import com.backend.banksphs.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="/api/v1/accounts")
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public List<Account> getAccount() {return accountService.getAccount();}

    @GetMapping
    public  List<Account> getActiveAccounts(){return accountService.getActiveAccount();}

    @GetMapping
    public  List<Account> getInactiveAccounts() {return accountService.getInactiveAccount();}

    @PostMapping
    public void findAccount(@RequestBody Account account){accountService.findAccount(account);}




}
