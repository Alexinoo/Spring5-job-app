package com.embarkx.jobapp.service.review;

import com.embarkx.jobapp.model.review.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews();
    Review getReview(Long reviewId);
    void createReview(Review newReview);
    boolean updateReview(Review updatedReview, Long reviewId);
    boolean deleteReview(Long reviewId);
}
