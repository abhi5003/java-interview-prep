package com.spring.example.LLD.DesignPatterns.caseStudies.StackOverFlow.model.contract;

import com.spring.example.LLD.DesignPatterns.caseStudies.StackOverFlow.model.entity.Answer;
import com.spring.example.LLD.DesignPatterns.caseStudies.StackOverFlow.model.entity.Question;
import com.spring.example.LLD.DesignPatterns.caseStudies.StackOverFlow.model.entity.Vote;

public interface ReputationObserver {
    void onVoteCast(Vote vote, Votable target);
    void onAnswerAccepted(Answer answer, Question question);
}
