package org.example.keynoteservice.services.impl;


import lombok.RequiredArgsConstructor;
import org.example.keynoteservice.DTOs.KeynoteRequestDTO;
import org.example.keynoteservice.entities.Keynote;
import org.example.keynoteservice.repositories.KeynoteRepository;
import org.example.keynoteservice.services.KeynoteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class KeynoteServiceImpl implements KeynoteService {

    private final KeynoteRepository keynoteRepository;

    @Override
    public List<Keynote> getAllKeynotes() {
        return keynoteRepository.findAll();
    }

    @Override
    public Optional<Keynote> getKeynoteById(Long id) {
        return keynoteRepository.findById(id);
    }

    @Override
    public Keynote createKeynote(Keynote keynote) {
        if (keynoteRepository.existsByEmail(keynote.getEmail())) {
            throw new IllegalArgumentException("Email already exists for another keynote");
        }
        return keynoteRepository.save(keynote);
    }

    @Override
    public Keynote createKeynote(KeynoteRequestDTO keynote) {
        KeynoteMapper mapper
    }

    @Override
    public Optional<Keynote> updateKeynote(Long id, Keynote updated) {
        return keynoteRepository.findById(id).map(existing -> {
            existing.setFirstName(updated.getFirstName());
            existing.setLastName(updated.getLastName());
            existing.setEmail(updated.getEmail());
            existing.setFunction(updated.getFunction());
            return keynoteRepository.save(existing);
        });
    }

    @Override
    public void deleteKeynote(Long id) {
        if (!keynoteRepository.existsById(id)) {
            throw new IllegalArgumentException("Keynote not found with id: " + id);
        }
        keynoteRepository.deleteById(id);
    }
}