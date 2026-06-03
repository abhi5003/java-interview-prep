package com.spring.example.LLD.DesignPatterns.caseStudies.ParkingLot;

public interface PaymentStrategy {
    double calculateCost(Ticket ticket);
    boolean processPayment(Ticket ticket, double amount);
}
