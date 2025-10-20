package org.example.eventservice.Services.impl;

import lombok.RequiredArgsConstructor;
import org.example.eventservice.Services.ConferenceService;
import org.example.eventservice.entities.Conference;
import org.example.eventservice.repositories.ConferenceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class ConferenceServiceImpl implements ConferenceService {

    private final ConferenceRepository conferenceRepository;

    @Override
    public Optional<Conference> insert(Conference c) {
        return Optional.of(conferenceRepository.save(c));
    }

    @Override
    public Optional<Conference> update(Long id , Conference c) {
        return conferenceRepository.findById(id).map(el->{

            el.setDate(c.getDate());
            el.setScore(c.getScore());
            el.setReviews(c.getReviews());
            el.setType(c.getType());
            el.setTitle(c.getTitle());
            el.setTimeSpan(c.getTimeSpan());
            el.setRegistrationCount(c.getRegistrationCount());

           return conferenceRepository.save(el);
        });

    }

    @Override
    public void deleteById(Long id) {

        conferenceRepository.deleteById(id);

    }

    @Override
    public List<Conference> getAll() {
        return conferenceRepository.findAll();
    }

    @Override
    public Optional<Conference> getById(Long id) {

        return conferenceRepository.findById(id);
    }
}
