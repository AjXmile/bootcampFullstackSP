package com.backend.banksphs;

import com.backend.banksphs.client.Client;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
public class BankSphsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankSphsApplication.class, args);
    }

}
