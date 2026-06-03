package com.spring.example.LLD.DesignPatterns.caseStudies.ParkingLot;

import java.time.Duration;

public class HourlyPaymentStrategy implements PaymentStrategy {
    private static final double HOURLY_RATE = 20.0;

    @Override
    public double calculateCost(Ticket ticket) {
        Duration duration = Duration.between(ticket.getEntryTime(), ticket.getExitTime());
        long hours = duration.toHours();
        if (duration.toMinutes() % 60 > 0) {
            hours++;
        }
        return Math.max(1, hours) * HOURLY_RATE;
    }

    @Override
    public boolean processPayment(Ticket ticket, double amount) {
        System.out.println("Payment of Rs " + amount + " received for ticket: " + ticket.getTicketId());
        return true;
    }
}
