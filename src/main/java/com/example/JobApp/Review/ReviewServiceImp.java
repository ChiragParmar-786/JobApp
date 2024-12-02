package com.example.JobApp.Review;

import com.example.JobApp.Company.Company;
import com.example.JobApp.Company.CompanyRepository;
import com.example.JobApp.Company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImp implements ReviewService {

    ReviewRepository reviewRepository;

    CompanyService companyService;

    public ReviewServiceImp(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Review> getAllReview(Long companyId) {
        Company company = companyService.findCompanyById(companyId);
        if( company != null) {
            return reviewRepository.findByCompanyId(companyId);
        }
        return null;
    }

    @Override
    public Boolean createReview(Long companyId,Review review) {
        Company company = companyService.findCompanyById(companyId);
        if( company != null)
        {
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Review findReviewById(Long companyId,Long reviewId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);

        return reviews.stream()
                .filter(review -> review.getId().equals(reviewId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Boolean removeReviewById(Long companyId,Long reviewId) {

        Company company = companyService.findCompanyById(companyId);

        if(company != null && reviewRepository.existsById(reviewId)){
            reviewRepository.deleteById(reviewId);
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public Boolean updateReviewById(Long companyId,Long reviewId, Review review) {

        Company company = companyService.findCompanyById(companyId);
        Review reviewToUpdate = reviewRepository.findById(reviewId).orElse(null);

         if(company != null && reviewToUpdate != null)
         {
             reviewToUpdate.setTitle(review.getTitle());
             reviewToUpdate.setDescription(review.getDescription());
             reviewToUpdate.setRating(review.getRating());
             reviewRepository.save(reviewToUpdate);
             return true;
         }
         else {
             return false;
         }
    }
}
