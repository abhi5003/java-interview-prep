package com.spring.example.LLD.DesignPatterns.caseStudies.ParkingLot;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

public class ParkingFloor {
    private int floorNumber;
    private List<ParkingSpot> spots;

    public ParkingFloor(int floorNumber, List<ParkingSpot> spots) {
        this.floorNumber = floorNumber;
        this.spots = new ArrayList<>(spots);
    }

    public Optional<ParkingSpot> findAvailableSpot(VehicleType vehicleType) {
        return spots.stream()
                .filter(s -> s.isAvailable() && s.getSpotType() == vehicleType)
                .findFirst();
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public List<ParkingSpot> getSpots() {
        return spots;
    }
}
