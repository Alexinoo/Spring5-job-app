package com.embarkx.jobapp.serviceimpl.review;

import com.embarkx.jobapp.model.review.Review;
import com.embarkx.jobapp.repository.review.ReviewRepository;
import com.embarkx.jobapp.service.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews;
    }
}
