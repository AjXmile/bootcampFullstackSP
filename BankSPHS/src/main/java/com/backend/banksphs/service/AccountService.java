package com.backend.banksphs.service;

import com.backend.banksphs.entity.Account;
import com.backend.banksphs.repository.AccountRepository;
import com.backend.banksphs.generationstatus.AccountStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AccountService {
    private final AccountRepository accountrepository;


    @Autowired
    public AccountService(AccountRepository accountrepository) {
        this.accountrepository = accountrepository;
    }

    public List<Account> getAccount() {
        return accountrepository.findAll();
    }

    public List<Account> getActiveAccount() {
        return accountrepository.findByAccountStatus(AccountStatus.ACTIVE);
    }

    public List<Account> getInactiveAccount() {
        return accountrepository.findByAccountStatus(AccountStatus.INACTIVE);
    }

    public void findAccount(Account account) {
        Optional<Account> accountById = accountrepository.findAccountById(account.getAccountId());
        if (accountById.isPresent()) {
            throw new IllegalStateException("Alredy Registered Account");
        }
        accountrepository.getReferenceById(account.getAccountId());
    }
}
