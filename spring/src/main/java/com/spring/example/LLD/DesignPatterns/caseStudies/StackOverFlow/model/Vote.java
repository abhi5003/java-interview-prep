package com.spring.example.LLD.DesignPatterns.caseStudies.StackOverFlow.model;

import java.time.LocalDateTime;

public class Vote {
    private String id;
    private User voter;
    private VoteType type;
    private Votable target;
    private LocalDateTime createdAt;

    public Vote(String id, User voter, VoteType type, Votable target) {
        this.id = id;
        this.voter = voter;
        this.type = type;
        this.target = target;
        this.createdAt = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getVoter() {
        return voter;
    }

    public void setVoter(User voter) {
        this.voter = voter;
    }

    public VoteType getType() {
        return type;
    }

    public void setType(VoteType type) {
        this.type = type;
    }

    public Votable getTarget() {
        return target;
    }

    public void setTarget(Votable target) {
        this.target = target;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
