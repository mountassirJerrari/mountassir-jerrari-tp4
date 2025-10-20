package org.example.eventservice.Services;

import org.example.eventservice.entities.Conference;
import org.example.eventservice.entities.Review;

import java.util.List;

public interface ReviewService {


    public Review createReview(Review review);

    public List<Review> getReviewsForConference(Conference conference);

    public List<Review> getAllReviews() ;
}
