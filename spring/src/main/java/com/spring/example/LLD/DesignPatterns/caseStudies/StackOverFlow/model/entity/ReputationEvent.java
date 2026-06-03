package com.spring.example.LLD.DesignPatterns.caseStudies.StackOverFlow.model.entity;

import java.time.LocalDateTime;

import com.spring.example.LLD.DesignPatterns.caseStudies.StackOverFlow.model.enums.ReputationAction;

public class ReputationEvent {
    private String id;
    private User user;
    private ReputationAction action;
    private int amount;
    private String sourceId;
    private LocalDateTime createdAt;

    public ReputationEvent(String id, User user, ReputationAction action, int amount, String sourceId) {
        this.id = id;
        this.user = user;
        this.action = action;
        this.amount = amount;
        this.sourceId = sourceId;
        this.createdAt = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ReputationAction getAction() {
        return action;
    }

    public void setAction(ReputationAction action) {
        this.action = action;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
