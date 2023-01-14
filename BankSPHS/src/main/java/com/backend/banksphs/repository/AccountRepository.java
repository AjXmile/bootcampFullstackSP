package com.backend.banksphs.repository;

import com.backend.banksphs.entity.Account;
import com.backend.banksphs.generationstatus.AccountStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long > {

    //Select * From Client where Id_num = ?
    @Query("SELECT c FROM Account c WHERE c.accountId = ?1")
    Optional<Account> findAccountById(Long accountId);

    Long findByAccountStatus(AccountStatus accountstatus);


}