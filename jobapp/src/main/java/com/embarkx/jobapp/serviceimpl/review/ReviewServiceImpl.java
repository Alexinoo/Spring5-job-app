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

    @Override
    public Review getReview(Long companyId, Long reviewId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);

//        return reviews.stream()
//                .filter(review -> reviewId.equals(review.getId()))
//                .findFirst()
//                .orElse(null);
        for (Review review : reviews){
            if (reviewId.equals(review.getId())){
                return review;
            }
        }
        return null;
    }

    @Override
    public boolean updateReviewById(Review updatedReview, Long companyId, Long reviewId) {
        Company company = companyService.getCompany(companyId);
        if ( company != null){
            updatedReview.setCompany(company);
            updatedReview.setId(reviewId);
            reviewRepository.save(updatedReview);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteReviewById(Long companyId, Long reviewId) {
        Company existingCompany = companyService.getCompany(companyId);
        boolean isReviewExist = reviewRepository.existsById(reviewId);
        if ( existingCompany != null && isReviewExist){
            Review review = reviewRepository.findById(reviewId).orElse(null);
            Company company = review.getCompany();
            company.getReviews().remove(review);
            review.setCompany(null);
            companyService.updateCompany(company , companyId);
            reviewRepository.deleteById(reviewId);
            return true;
        }
        return false;
    }

}
