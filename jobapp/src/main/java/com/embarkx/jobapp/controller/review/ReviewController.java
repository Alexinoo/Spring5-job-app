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

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews(){
        return ResponseEntity.ok(reviewService.getAllReviews());
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> getSingleReview(@PathVariable Long reviewId){
        return new ResponseEntity<>(reviewService.getReview(reviewId) , HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<String> createReview(@RequestBody Review newReview){
        reviewService.createReview(newReview);
        return new ResponseEntity<>("Review added Successfully",HttpStatus.CREATED);
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<String> updateReview(@RequestBody Review updatedReview,
                                               @PathVariable Long reviewId){

        boolean isReviewUpdated = reviewService.updateReview(updatedReview , reviewId);
        if (isReviewUpdated)
            return new ResponseEntity<>("Review updated Successfully", HttpStatus.OK);

        return new ResponseEntity<>("Review Not Found",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long reviewId){
        boolean isReviewDeleted = reviewService.deleteReview(reviewId);
        if (isReviewDeleted)
            return new ResponseEntity<>("Review deleted Successfully", HttpStatus.OK);

        return new ResponseEntity<>("Review Not Found",HttpStatus.NOT_FOUND);
    }
}
