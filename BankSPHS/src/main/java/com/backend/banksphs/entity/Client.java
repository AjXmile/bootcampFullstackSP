package com.backend.banksphs.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Client {
    @Id
    @SequenceGenerator(
            name = "client_sequence",
            sequenceName = "client_sequence_id",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "client_sequence"
    )
    private Long id;
    private Long idNum;
    private String idType;
    private String name;
    private String surname;
    private String  email;
    private LocalDate dod;
    @Transient
    private LocalDate age;
    private String ownerCreation;
    private LocalDate creationDate;
    private String ownerModification;
    private LocalDate modificationDate;

    public Client() {
    }

    public Client(Long id, Long idNum, String idType, String name, String surname, String email, LocalDate dod) {
        this.id = id;
        this.idNum = idNum;
        this.idType = idType;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.dod = dod;
    }

    public Client(Long idNum, String idType, String name, String surname, String email, LocalDate dod) {
        this.idNum = idNum;
        this.idType =idType;
        this.name = name;
        this.surname =surname;
        this.email = email;
        this.dod = dod;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDod() {
        return dod;
    }

    public void setDod(LocalDate dod) {
        this.dod = dod;
    }

    public Long getIdNum() {
        return idNum;
    }

    public void setIdNum(Long idNum) {
        this.idNum = idNum;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getOwnerCreation() {return System.getProperty("user.name");}

    public void setOwnerCreation(String ownerCreation) {this.ownerCreation = ownerCreation;}

    public LocalDate getCreationDate() {
        return LocalDate.now();
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public String getOwnerModification(String property) {return System.getProperty("user.name");    }

    public void setOwnerModification(String owner) {
        this.ownerModification = owner;
    }

    public LocalDate getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(LocalDate ownerModification) {
        this.modificationDate = ownerModification;
    }

    public Integer getAge() {
        return Period.between(this.dod, LocalDate.now()).getYears();
    }

    public void setAge(LocalDate age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", idNum=" + idNum +
                ", idType='" + idType + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", dod=" + dod +
                ", age=" + age +
                ", ownerCreation='" + ownerCreation + '\'' +
                ", creationDate=" + creationDate +
                ", ownerModification='" + ownerModification + '\'' +
                ", modificationDate=" + modificationDate +
                '}';
    }


}
