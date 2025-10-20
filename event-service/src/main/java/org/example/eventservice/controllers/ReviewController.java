package org.example.eventservice.controllers;

import lombok.RequiredArgsConstructor;
import org.example.eventservice.DTOs.CreateReviewDTO;
import org.example.eventservice.Services.ReviewService;
import org.example.eventservice.entities.Conference;
import org.example.eventservice.entities.Review;
import org.example.eventservice.repositories.ConferenceRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;
    private final ConferenceRepository conferenceRepository;

    // Create review from DTO
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Review createReview(@RequestBody CreateReviewDTO dto) {
        Conference conference = conferenceRepository.findById(dto.getConferenceId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Conference not found"));

        Review review = new Review();
        review.setFeedback(dto.getFeedback());
        review.setStars(dto.getStars());
        review.setDate(new java.util.Date());
        review.setConference(conference);

        return reviewService.createReview(review);
    }

    // Get all reviews
    @GetMapping
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    // Get reviews by conference
    @GetMapping("/conference/{conferenceId}")
    public List<Review> getReviewsForConference(@PathVariable Long conferenceId) {
        Conference conference = conferenceRepository.findById(conferenceId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Conference not found"));
        return reviewService.getReviewsForConference(conference);
    }
}
