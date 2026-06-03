package com.spring.example.LLD.DesignPatterns.caseStudies.ParkingLot;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.getInstance();

        ParkingFloor floor1 = new ParkingFloor(1, List.of(
                new ParkingSpot(1, VehicleType.BIKE),
                new ParkingSpot(2, VehicleType.BIKE),
                new ParkingSpot(3, VehicleType.CAR),
                new ParkingSpot(4, VehicleType.CAR),
                new ParkingSpot(5, VehicleType.TRUCK)
        ));

        ParkingFloor floor2 = new ParkingFloor(2, List.of(
                new ParkingSpot(1, VehicleType.CAR),
                new ParkingSpot(2, VehicleType.CAR),
                new ParkingSpot(3, VehicleType.TRUCK)
        ));

        parkingLot.addFloor(floor1);
        parkingLot.addFloor(floor2);

        EntryGate entryGate1 = new EntryGate("E1", new NaturalOrderParkingStrategy());
        EntryGate entryGate2 = new EntryGate("E2", new NaturalOrderParkingStrategy());
        parkingLot.addEntryGate(entryGate1);
        parkingLot.addEntryGate(entryGate2);

        ExitGate exitGate1 = new ExitGate("X1", new HourlyPaymentStrategy());
        ExitGate exitGate2 = new ExitGate("X2", new HourlyPaymentStrategy());
        parkingLot.addExitGate(exitGate1);
        parkingLot.addExitGate(exitGate2);

        System.out.println("Available spots: " + parkingLot.getAvailableSpotsCount());

        Vehicle bike = new Vehicle("KA-01-1234", VehicleType.BIKE) {};
        Optional<Ticket> ticket1 = parkingLot.parkVehicle(bike);
        ticket1.ifPresent(t -> System.out.println("Ticket: " + t.getTicketId() + " | Spot: " + t.getParkingSpot().getSpotNumber() + " | Floor: " + t.getFloorNumber()));

        Vehicle car = new Vehicle("KA-02-5678", VehicleType.CAR) {};
        Optional<Ticket> ticket2 = parkingLot.parkVehicle(car);
        ticket2.ifPresent(t -> System.out.println("Ticket: " + t.getTicketId() + " | Spot: " + t.getParkingSpot().getSpotNumber() + " | Floor: " + t.getFloorNumber()));

        System.out.println("Available spots: " + parkingLot.getAvailableSpotsCount());

        ticket1.ifPresent(t -> {
            boolean success = parkingLot.unparkVehicle(t.getTicketId());
            System.out.println("Unpark success: " + success);
        });

        System.out.println("Available spots: " + parkingLot.getAvailableSpotsCount());
    }
}
