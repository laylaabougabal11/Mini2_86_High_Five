package com.example.miniapp.services;

import com.example.miniapp.models.Trip;
import com.example.miniapp.repositories.TripRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TripService {

    private final TripRepository tripRepository;

    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    // 8.3.2.1 Add Trip
    public Trip addTrip(Trip trip) {
        return tripRepository.save(trip);
    }

    // 8.3.2.2 Get All Trips
    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    // 8.3.2.3 Get Trip By ID
    public Trip getTripById(Long id) {
        return tripRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trip not found with id " + id));
    }

    // 8.3.2.4 Update Trip
    public Trip updateTrip(Long id, Trip trip) {
        Trip existing = getTripById(id);
        existing.setTripDate(trip.getTripDate());
        existing.setOrigin(trip.getOrigin());
        existing.setDestination(trip.getDestination());
        existing.setTripCost(trip.getTripCost());
        existing.setCaptain(trip.getCaptain());
        existing.setCustomer(trip.getCustomer());
        return tripRepository.save(existing);
    }

    // 8.3.2.5 Delete Trip
    public void deleteTrip(Long id) {
        tripRepository.deleteById(id);
    }

    // 8.3.2.6 Find Trips Within a Date Range
    public List<Trip> findTripsWithinDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        return tripRepository.findByTripDateBetween(startDate, endDate);
    }

    // 8.3.2.7 Find Trips By Captain ID
    public List<Trip> findTripsByCaptainId(Long captainId) {
        return tripRepository.findByCaptainId(captainId);
    }
}
