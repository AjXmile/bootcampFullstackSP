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
    public void getAccount(Account account) {accountService.getAccount(account);}

    @GetMapping
    public void getActiveAccounts(Account account){accountService.getActiveAccount(account);}

    @GetMapping
    public void getInactiveAccounts(Account account) {accountService.getInactiveAccount(account);}

    @GetMapping
    public void getCancelAccounts(Account account) {accountService.getCancelAccount(account);}

    @PostMapping(path = "{accountId}")
    public void findAccount(@PathVariable("accountId") Long accountId){accountService.findAccount(accountId);}
    }
