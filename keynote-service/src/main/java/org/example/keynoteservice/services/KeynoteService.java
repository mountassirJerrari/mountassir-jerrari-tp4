package org.example.keynoteservice.services;

import org.example.keynoteservice.entities.Keynote;

import java.util.List;
import java.util.Optional;

public interface KeynoteService {
    List<Keynote> getAllKeynotes();
    Optional<Keynote> getKeynoteById(Long id);
    Keynote createKeynote(Keynote keynote);
    Optional<Keynote> updateKeynote(Long id, Keynote keynote);
    void deleteKeynote(Long id);
}
