package com.spring.example.LLD.DesignPatterns.caseStudies.StackOverFlow.model;

import java.util.List;

public interface Votable {
    List<Vote> getVotes();
    void addVote(Vote vote);
    void removeVote(Vote vote);
}
