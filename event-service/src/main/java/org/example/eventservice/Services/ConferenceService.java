package org.example.eventservice.Services;

import org.example.eventservice.entities.Conference;

import java.util.List;
import java.util.Optional;

public interface ConferenceService {

     Optional<Conference> insert(Conference c);
     Optional<Conference> update( Long id , Conference c);
     void deleteById( Long id);
     List<Conference> getAll();
     Optional<Conference> getById(Long id);


}
