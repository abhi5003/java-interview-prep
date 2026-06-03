package com.spring.example.LLD.DesignPatterns.caseStudies.ParkingLot;

public abstract class Vehicle {
    private String registrationNumber;
    private VehicleType vehicleType;

    public Vehicle(String registrationNumber, VehicleType vehicleType) {
        this.registrationNumber = registrationNumber;
        this.vehicleType = vehicleType;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
