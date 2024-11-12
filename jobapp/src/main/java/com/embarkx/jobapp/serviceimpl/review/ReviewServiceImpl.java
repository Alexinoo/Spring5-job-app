package com.embarkx.jobapp.serviceimpl.review;

import com.embarkx.jobapp.model.company.Company;
import com.embarkx.jobapp.model.review.Review;
import com.embarkx.jobapp.repository.review.ReviewRepository;
import com.embarkx.jobapp.service.company.CompanyService;
import com.embarkx.jobapp.service.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;
    private CompanyService companyService;

    public ReviewServiceImpl(ReviewRepository reviewRepository,CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public boolean addReview(Review newReview, Long companyId) {
        Company company = companyService.getCompany(companyId);
        if (company != null){
            newReview.setCompany(company);
            reviewRepository.save(newReview);
            return true;
        }
        return false;
    }

}
