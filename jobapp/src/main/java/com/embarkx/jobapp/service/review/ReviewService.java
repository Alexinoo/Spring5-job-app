package com.embarkx.jobapp.service.review;

import com.embarkx.jobapp.model.review.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long companyId);
    boolean addReview(Review newReview , Long companyId);
}
