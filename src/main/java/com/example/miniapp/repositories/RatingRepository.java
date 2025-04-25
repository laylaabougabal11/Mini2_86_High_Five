package com.example.miniapp.repositories;

import com.example.miniapp.models.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends MongoRepository<Rating, String> {

    // Find all ratings for a specific entity (captain, customer, or trip)
    List<Rating> findByEntityIdAndEntityType(Long entityId, String entityType);

    // Retrieve all ratings whose score is greater than the given value
    List<Rating> findByScoreGreaterThan(Integer minScore);
}
