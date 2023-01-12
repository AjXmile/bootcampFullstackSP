package com.backend.banksphs.accountdeclaration.accountrepository;

import com.backend.banksphs.accountdeclaration.accountentity.Account;
import com.backend.banksphs.generationstatus.AccountStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long > {

    //Select * From Client where Id_num = ?
    @Query("SELECT c FROM Account c WHERE c.accountId = ?1")
    Optional<Account> findAccountById(Long accountId);

    List<Account> findByAccountStatus(AccountStatus accountstatus);


}