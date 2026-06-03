package com.spring.example.LLD.DesignPatterns.caseStudies.ParkingLot;

public class ParkingSpot {
    private int spotNumber;
    private VehicleType spotType;
    private boolean isAvailable;
    private Vehicle parkedVehicle;

    public ParkingSpot(int spotNumber, VehicleType spotType) {
        this.spotNumber = spotNumber;
        this.spotType = spotType;
        this.isAvailable = true;
    }

    public synchronized boolean parkVehicle(Vehicle vehicle) {
        if (!isAvailable || !canFitVehicle(vehicle)) {
            return false;
        }
        this.parkedVehicle = vehicle;
        this.isAvailable = false;
        return true;
    }

    public synchronized Vehicle unparkVehicle() {
        Vehicle vehicle = this.parkedVehicle;
        this.parkedVehicle = null;
        this.isAvailable = true;
        return vehicle;
    }

    private boolean canFitVehicle(Vehicle vehicle) {
        return this.spotType == vehicle.getVehicleType();
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public VehicleType getSpotType() {
        return spotType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }
}
