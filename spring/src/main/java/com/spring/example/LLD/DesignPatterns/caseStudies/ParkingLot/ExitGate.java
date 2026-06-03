package com.spring.example.LLD.DesignPatterns.caseStudies.ParkingLot;

public class ExitGate {
    private String gateId;
    private PaymentStrategy paymentStrategy;

    public ExitGate(String gateId, PaymentStrategy paymentStrategy) {
        this.gateId = gateId;
        this.paymentStrategy = paymentStrategy;
    }

    public boolean processExit(Ticket ticket) {
        ticket.markExit();
        double amount = paymentStrategy.calculateCost(ticket);
        return paymentStrategy.processPayment(ticket, amount);
    }

    public String getGateId() {
        return gateId;
    }
}
