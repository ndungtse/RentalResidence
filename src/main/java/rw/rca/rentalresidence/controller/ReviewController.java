package rw.rca.rentalresidence.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import rw.rca.rentalresidence.model.Review;
import rw.rca.rentalresidence.service.ReviewService;
import rw.rca.rentalresidence.util.CustomResponse;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/reviews")
@Api(tags = "Reviews")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public ResponseEntity<CustomResponse<Review>> createReview(@RequestBody Review review) {
        try {
            return ResponseEntity.created(null).body(new CustomResponse<>("Review created successfully", reviewService.createReview(review), true));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new CustomResponse<>("Review not created", null, false));
        }
    }

    @GetMapping
    public ResponseEntity<CustomResponse<List<Review>>> getAllReviews() {
        try {
            return ResponseEntity.ok(new CustomResponse<>("Reviews found successfully", reviewService.getAllReviews(), true));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new CustomResponse<>("Reviews not found", null, false));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse<Optional<Review>>> getReviewById(@PathVariable("id") String id) {
        try {
            return ResponseEntity.ok(new CustomResponse<>("Review found successfully", reviewService.getReviewById(id), true));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new CustomResponse<>("Review not found", null, false));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomResponse<?>> deleteReview(@PathVariable("id") String id) {
        try {
            reviewService.deleteReview(id);
            return ResponseEntity.accepted().body(new CustomResponse<>("Review deleted successfully", null, true));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new CustomResponse<>("Review not deleted", null, false));
        }
    }
}
