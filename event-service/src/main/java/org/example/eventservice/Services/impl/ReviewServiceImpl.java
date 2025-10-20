package org.example.eventservice.Services.impl;

import lombok.RequiredArgsConstructor;
import org.example.eventservice.Services.ReviewService;
import org.example.eventservice.entities.Conference;
import org.example.eventservice.entities.Review;
import org.example.eventservice.repositories.ConferenceRepository;
import org.example.eventservice.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final ConferenceRepository conferenceRepository;

    @Override
    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }
    @Override
    public List<Review> getReviewsForConference(Conference conference) {
        return reviewRepository.findByConferenceId(conference.getId());
    }
    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }
}