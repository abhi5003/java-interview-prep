package com.spring.example.LLD.DesignPatterns.caseStudies.StackOverFlow.model.contract;

import java.util.List;

import com.spring.example.LLD.DesignPatterns.caseStudies.StackOverFlow.model.entity.Vote;

public interface Votable {
    List<Vote> getVotes();
    void addVote(Vote vote);
    void removeVote(Vote vote);
}
