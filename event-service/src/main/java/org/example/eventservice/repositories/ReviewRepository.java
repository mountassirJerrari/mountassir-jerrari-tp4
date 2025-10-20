package org.example.eventservice.repositories;

import org.example.eventservice.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Long> {

    List<Review> findByConferenceId(Long conferenceId);
}
