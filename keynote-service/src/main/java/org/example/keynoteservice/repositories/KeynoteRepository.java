package org.example.keynoteservice.repositories;

import org.example.keynoteservice.entities.Keynote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeynoteRepository extends JpaRepository<Keynote, Long> {
    boolean existsByEmail(String email);
}
