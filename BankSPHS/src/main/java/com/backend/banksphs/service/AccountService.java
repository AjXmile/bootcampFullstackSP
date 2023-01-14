package com.backend.banksphs.service;

import com.backend.banksphs.entity.Account;
import com.backend.banksphs.generationstatus.AccountStatus;
import com.backend.banksphs.generationstatus.AccountType;
import com.backend.banksphs.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class AccountService {
    private final AccountRepository accountrepository;


    @Autowired
    public AccountService(AccountRepository accountrepository) {
        this.accountrepository = accountrepository;
    }

    public void addNewAccountToClient(Account account) {
        Optional<Account> accountByIdNumber = accountrepository.findAccountById(account.getId());
        if (accountByIdNumber.isPresent()){
            throw new IllegalStateException("Already Registered");
        }
        if (Objects.equals(account.getAccountType(AccountType.SAVINGS), AccountType.SAVINGS)){
            return
        }
        accountrepository.save(account);
    }
    public void getAccount(Account account) {
        Optional<Account> accountByIdNum = accountrepository.findAccountById(account.getId());
        if (accountByIdNum.isEmpty()){
            throw new IllegalStateException("It's not a Account");
        }
        accountrepository.findAccountById(account.getId());
    }

    public void getActiveAccount(Account account) {
        Optional<Account> accountOptional =
                accountrepository.findAccountById(accountrepository.findByAccountStatus(AccountStatus.ACTIVE));
        if (accountOptional.isEmpty()){
            throw new IllegalStateException("Not Active Accounts");
        }
        accountrepository.findAccountById(account.getId());
    }

    public void getInactiveAccount(Account account) {
        Optional<Account> accountOptional =
                accountrepository.findAccountById(accountrepository.findByAccountStatus(AccountStatus.INACTIVE));
        if (accountOptional.isEmpty()){
            throw new IllegalStateException("Not Inactive Accounts");
        }
        accountrepository.findAccountById(account.getId());
    }

    public void getCancelAccount(Account account) {
        Optional<Account> accountOptional =
                accountrepository.findAccountById(accountrepository.findByAccountStatus(AccountStatus.CANCEL));
        if (accountOptional.isEmpty()){
            throw new IllegalStateException("Not Cancel Accounts");
        }
        accountrepository.findAccountById(account.getId());
    }
    public void findAccount(Long accountId) {
        Optional<Account> accountById = accountrepository.findAccountById(accountId);
        if (accountById.isPresent()) {
            throw new IllegalStateException("Already Registered Account");
        }
        accountrepository.getReferenceById(accountId);
    }
}
