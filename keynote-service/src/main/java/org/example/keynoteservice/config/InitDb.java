package org.example.keynoteservice.config;

import org.example.keynoteservice.entities.Keynote;
import org.example.keynoteservice.repositories.KeynoteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitDb {

    @Bean
    CommandLineRunner initKeynotes(KeynoteRepository keynoteRepository) {
        return args -> {

            for (int i = 1; i <= 8; i++) {
                Keynote keynote = Keynote.builder()
                        .firstName("FirstName" + i)
                        .lastName("LastName" + i)
                        .email("keynote" + i + "@example.com")
                        .function("Function" + i)
                        .build();
                keynoteRepository.save(keynote);
            }

            System.out.println("✅ 8 Keynotes initialized in DB!");
        };
    }
}
