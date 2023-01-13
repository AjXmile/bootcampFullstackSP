package com.backend.banksphs.configuration;

import com.backend.banksphs.entity.Client;
import com.backend.banksphs.repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class ClientConfig {

    @Bean
    CommandLineRunner commandLineRunner (ClientRepository repository){
        return args -> {
            Client maria = new Client(
                    543L,
                    "CC",
                    "Maria",
                    "Jamal",
                    "maria@gmail.com",
                    LocalDate.of(2000, Month.JANUARY, 11)
            );
            Client marian = new Client(
                    879L,
                    "CE",
                    "Marian",
                    "Gez",
                    "marian@gmail.com",
                    LocalDate.of(2004, Month.JANUARY, 5)
            );

            repository.saveAll(
                    List.of(maria,marian)
            );
        };
    }
}
