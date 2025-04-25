package com.example.miniapp.repositories;

import com.example.miniapp.models.Captain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaptainRepository extends JpaRepository<Captain, Long> {

    // Find all captains whose avgRatingScore is above the given threshold
    List<Captain> findByAvgRatingScoreGreaterThan(Double ratingThreshold);

    // Find a single captain by their license number
    Captain findByLicenseNumber(String licenseNumber);
}
