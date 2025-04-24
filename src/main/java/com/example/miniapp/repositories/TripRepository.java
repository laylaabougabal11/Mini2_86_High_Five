package com.example.miniapp.repositories;

import com.example.miniapp.models.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {

    // Retrieve all trips that occurred between startDate and endDate
    List<Trip> findByTripDateBetween(LocalDateTime startDate, LocalDateTime endDate);

    // Retrieve all trips associated with a given captain’s ID
    List<Trip> findByCaptainId(Long captainId);
}
