package com.embarkx.jobapp.controller.review;

import com.embarkx.jobapp.model.review.Review;
import com.embarkx.jobapp.service.review.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/companies/{companyId}")
public class ReviewController {

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId){
        return ResponseEntity.ok(reviewService.getAllReviews(companyId));
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@RequestBody Review newReview, @PathVariable Long companyId){
        boolean isReviewSaved = reviewService.addReview(newReview , companyId);
        if (isReviewSaved)
            return new ResponseEntity<>("Review for company with id "+ companyId +" added successfully.", HttpStatus.CREATED);
        return new ResponseEntity<>("Review Not Saved",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long companyId , @PathVariable Long reviewId){
            return new ResponseEntity<>(reviewService.getReview(companyId,reviewId), HttpStatus.OK);
    }
}
















