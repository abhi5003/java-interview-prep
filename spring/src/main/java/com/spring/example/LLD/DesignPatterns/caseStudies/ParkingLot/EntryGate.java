package com.spring.example.LLD.DesignPatterns.caseStudies.ParkingLot;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class EntryGate {
    private String gateId;
    private ParkingStrategy parkingStrategy;

    public EntryGate(String gateId, ParkingStrategy parkingStrategy) {
        this.gateId = gateId;
        this.parkingStrategy = parkingStrategy;
    }

    public Optional<Ticket> generateTicket(List<ParkingFloor> floors, Vehicle vehicle) {
        Optional<ParkingSpot> spotOpt = parkingStrategy.findSpot(floors, vehicle);
        if (spotOpt.isEmpty()) {
            return Optional.empty();
        }

        ParkingSpot spot = spotOpt.get();
        spot.parkVehicle(vehicle);

        int floorNumber = floors.stream()
                .filter(f -> f.getSpots().contains(spot))
                .findFirst()
                .map(ParkingFloor::getFloorNumber)
                .orElseThrow();

        String ticketId = UUID.randomUUID().toString();
        Ticket ticket = new Ticket(ticketId, vehicle, spot, floorNumber, gateId);
        return Optional.of(ticket);
    }

    public String getGateId() {
        return gateId;
    }
}
