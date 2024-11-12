package com.embarkx.jobapp.repository.review;

import com.embarkx.jobapp.model.review.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {
}
