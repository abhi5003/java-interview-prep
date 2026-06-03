package com.spring.example.LLD.DesignPatterns.caseStudies.ParkingLot;

import java.util.List;
import java.util.Optional;

public class NaturalOrderParkingStrategy implements ParkingStrategy {
    @Override
    public Optional<ParkingSpot> findSpot(List<ParkingFloor> floors, Vehicle vehicle) {
        for (ParkingFloor floor : floors) {
            Optional<ParkingSpot> spotOpt = floor.findAvailableSpot(vehicle.getVehicleType());
            if (spotOpt.isPresent()) {
                return spotOpt;
            }
        }
        return Optional.empty();
    }
}
