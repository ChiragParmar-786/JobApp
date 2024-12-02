package com.example.JobApp.Review;

import com.example.JobApp.Job.Job;

import java.util.List;

public interface ReviewService {

    List<Review> getAllReview(Long companyId);

    Boolean createReview(Long companyId,Review review);

    Review findReviewById(Long companyId,Long reviewId);

    Boolean removeReviewById(Long companyId,Long reviewId);

    Boolean updateReviewById(Long companyId,Long reviewId, Review review);
}
