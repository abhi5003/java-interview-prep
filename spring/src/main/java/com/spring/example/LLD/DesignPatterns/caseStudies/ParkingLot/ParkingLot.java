package com.spring.example.LLD.DesignPatterns.caseStudies.ParkingLot;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingLot {
    private static volatile ParkingLot instance;
    private List<ParkingFloor> floors;
    private List<EntryGate> entryGates;
    private List<ExitGate> exitGates;
    private Map<String, Ticket> activeTickets;

    private ParkingLot() {
        this.floors = new ArrayList<>();
        this.entryGates = new ArrayList<>();
        this.exitGates = new ArrayList<>();
        this.activeTickets = new ConcurrentHashMap<>();
    }

    public static ParkingLot getInstance() {
        if (instance == null) {
            synchronized (ParkingLot.class) {
                if (instance == null) {
                    instance = new ParkingLot();
                }
            }
        }
        return instance;
    }

    public void addFloor(ParkingFloor floor) {
        floors.add(floor);
    }

    public void addEntryGate(EntryGate gate) {
        entryGates.add(gate);
    }

    public void addExitGate(ExitGate gate) {
        exitGates.add(gate);
    }

    public Optional<Ticket> parkVehicle(Vehicle vehicle) {
        for (EntryGate gate : entryGates) {
            Optional<Ticket> ticketOpt = gate.generateTicket(floors, vehicle);
            if (ticketOpt.isPresent()) {
                Ticket ticket = ticketOpt.get();
                activeTickets.put(ticket.getTicketId(), ticket);
                return Optional.of(ticket);
            }
        }
        return Optional.empty();
    }

    public boolean unparkVehicle(String ticketId) {
        Ticket ticket = activeTickets.get(ticketId);
        if (ticket == null) {
            return false;
        }

        for (ExitGate gate : exitGates) {
            if (gate.processExit(ticket)) {
                ticket.getParkingSpot().unparkVehicle();
                activeTickets.remove(ticketId);
                return true;
            }
        }
        return false;
    }

    public int getAvailableSpotsCount() {
        return floors.stream()
                .flatMap(f -> f.getSpots().stream())
                .filter(ParkingSpot::isAvailable)
                .mapToInt(s -> 1)
                .sum();
    }

    public List<ParkingFloor> getFloors() {
        return floors;
    }

    public List<EntryGate> getEntryGates() {
        return entryGates;
    }

    public List<ExitGate> getExitGates() {
        return exitGates;
    }
}
