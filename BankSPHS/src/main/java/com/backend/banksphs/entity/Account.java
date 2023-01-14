package com.backend.banksphs.entity;

import com.backend.banksphs.generationstatus.AccountStatus;
import com.backend.banksphs.generationstatus.AccountType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Table

public class Account {
    @Id
    @SequenceGenerator(
            name = "account_sequence",
            sequenceName = "account_sequence_id",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "account_sequence"
    )
    private Long id;
    private String accountType;
    private Long accountId;
    private AccountStatus accountStatus;
    private BigDecimal amount;
    private BigDecimal currentBalance;
    private String exemptGMF;

    @Transient
    private Long clientId;
    private LocalDate creationDate;
    private String ownerCreation;
    private LocalDate modificationDate;
    private String ownerModification;

    public Account(){
    }

    public Account(Long id, String accountType, Long accountId, AccountStatus accountStatus,
                   BigDecimal amount, BigDecimal currentBalance, String exemptGMF) {
        this.id = id;
        this.accountType = accountType;
        this.accountId = accountId;
        this.accountStatus = accountStatus;
        this.amount = amount;
        this.currentBalance = currentBalance;
        this.exemptGMF = exemptGMF;
    }

    public Account(String accountType, Long accountId, AccountStatus accountStatus,
                   BigDecimal amount, BigDecimal currentBalance, String exemptGMF) {
        this.accountType = accountType;
        this.accountId = accountId;
        this.accountStatus = accountStatus;
        this.amount = amount;
        this.currentBalance = currentBalance;
        this.exemptGMF = exemptGMF;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getAccountType(AccountType savings) {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = String.valueOf(AccessType.valueOf(accountType));
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = AccountStatus.valueOf(accountStatus);
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }

    public String getExemptGMF() {
        return exemptGMF;
    }

    public void setExemptGMF(String exemptGMF) {
        this.exemptGMF = exemptGMF;
    }

    public LocalDate getCreationDate() {
        return LocalDate.now();
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public String getOwnerCreation() {
        return System.getProperty("user.name");
    }

    public void setOwnerCreation(String ownerCreation) {
        this.ownerCreation = ownerCreation;
    }

    public LocalDate getModificationDate() {
        return LocalDate.now();
    }

    public void setModificationDate(LocalDate modificationDate) {
        this.modificationDate = modificationDate;
    }

    public String getOwnerModification() {
        return System.getProperty("user.name");
    }

    public void setOwnerModification(String ownerModification) {
        this.ownerModification = ownerModification;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountType='" + accountType + '\'' +
                ", accountId=" + accountId +
                ", accountStatus='" + accountStatus + '\'' +
                ", amount=" + amount +
                ", currentBalance=" + currentBalance +
                ", exemptGMF='" + exemptGMF + '\'' +
                ", creationDate=" + creationDate +
                ", ownerCreation='" + ownerCreation + '\'' +
                ", modificationDate=" + modificationDate +
                ", ownerModification='" + ownerModification + '\'' +
                '}';
    }
}
