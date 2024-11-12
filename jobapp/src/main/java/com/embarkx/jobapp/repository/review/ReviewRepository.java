package com.embarkx.jobapp.repository.review;

import com.embarkx.jobapp.model.review.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Long> {
    List<Review> findByCompanyId(Long companyId);
}