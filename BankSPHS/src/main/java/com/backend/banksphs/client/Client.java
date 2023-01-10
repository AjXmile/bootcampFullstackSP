package com.backend.banksphs.client;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Client {
    @Id
    @SequenceGenerator(
            name = "client_sequence",
            sequenceName = "client_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "client_sequence"
    )
    private Long id;
    private Long id_num;
    private String name;
    private String surname;
    private String  email;
    private LocalDate dod;
    @Transient
    private Integer age;
    private LocalDate creationDate;
    private String Owner;
    private LocalDate Owner_modification;

    public Client() {
    }

    public Client(Long id, Long id_num, String name, String surname, String email, LocalDate dod) {
        this.id = id;
        this.id_num = id_num;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.dod = dod;
    }

    public Client(Long id_num, String name, String surname, String email, LocalDate dod) {
        this.id_num = id_num;
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

    public Long getId_num() {
        return id_num;
    }

    public void setId_num(Long id_num) {
        this.id_num = id_num;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getCreationDate() {
        return LocalDate.now();
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public String getOwner() {
        return Owner;
    }

    public void setOwner(String owner) {
        Owner = owner;
    }

    public LocalDate getOwner_modification() {
        return Owner_modification;
    }

    public void setOwner_modification(LocalDate owner_modification) {
        Owner_modification = owner_modification;
    }

    public Integer getAge() {
        return Period.between(this.dod, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", id_num=" + id_num +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", dod=" + dod +
                ", age=" + age +
                ", creationDate=" + creationDate +
                ", Owner='" + Owner + '\'' +
                ", Owner_modification=" + Owner_modification +
                '}';
    }


}
