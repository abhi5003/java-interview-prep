package com.spring.example.LLD.DesignPatterns.caseStudies.ParkingLot;

import java.time.LocalDateTime;

public class Ticket {
    private String ticketId;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;
    private int floorNumber;
    private String entryGateId;

    public Ticket(String ticketId, Vehicle vehicle, ParkingSpot parkingSpot, int floorNumber, String entryGateId) {
        this.ticketId = ticketId;
        this.entryTime = LocalDateTime.now();
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.floorNumber = floorNumber;
        this.entryGateId = entryGateId;
    }

    public void markExit() {
        this.exitTime = LocalDateTime.now();
    }

    public String getTicketId() {
        return ticketId;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public String getEntryGateId() {
        return entryGateId;
    }
}
