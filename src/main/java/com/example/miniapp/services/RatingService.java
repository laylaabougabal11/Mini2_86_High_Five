package com.example.miniapp.services;

import com.example.miniapp.models.Rating;
import com.example.miniapp.repositories.RatingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;

    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    // 8.5.2.1 Add Rating
    public Rating addRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    // 8.5.2.2 Update Rating
    public Rating updateRating(String id, Rating updatedRating) {
        Rating existing = ratingRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Rating not found with id " + id));
        existing.setScore(updatedRating.getScore());
        existing.setComment(updatedRating.getComment());
        existing.setRatingDate(updatedRating.getRatingDate());
        return ratingRepository.save(existing);
    }

    // 8.5.2.3 Delete Rating
    public void deleteRating(String id) {
        ratingRepository.deleteById(id);
    }

    // 8.5.2.4 Get Ratings By Entity
    public List<Rating> getRatingsByEntity(Long entityId, String entityType) {
        return ratingRepository.findByEntityIdAndEntityType(entityId, entityType);
    }

    // 8.5.2.5 Find Ratings Above a Specific Value
    public List<Rating> findRatingsAboveScore(int minScore) {
        return ratingRepository.findByScoreGreaterThan(minScore);
    }
}
