package com.spring.example.LLD.DesignPatterns.caseStudies.StackOverFlow.service;

import java.util.ArrayList;
import java.util.List;

import com.spring.example.LLD.DesignPatterns.caseStudies.StackOverFlow.model.contract.ReputationObserver;
import com.spring.example.LLD.DesignPatterns.caseStudies.StackOverFlow.model.contract.Votable;
import com.spring.example.LLD.DesignPatterns.caseStudies.StackOverFlow.model.entity.Answer;
import com.spring.example.LLD.DesignPatterns.caseStudies.StackOverFlow.model.entity.Question;
import com.spring.example.LLD.DesignPatterns.caseStudies.StackOverFlow.model.entity.ReputationEvent;
import com.spring.example.LLD.DesignPatterns.caseStudies.StackOverFlow.model.entity.User;
import com.spring.example.LLD.DesignPatterns.caseStudies.StackOverFlow.model.entity.Vote;
import com.spring.example.LLD.DesignPatterns.caseStudies.StackOverFlow.model.enums.ReputationAction;
import com.spring.example.LLD.DesignPatterns.caseStudies.StackOverFlow.model.enums.VoteType;

public class ReputationManager implements ReputationObserver {
    private List<ReputationEvent> events = new ArrayList<>();
    private int nextId = 1;

    @Override
    public void onVoteCast(Vote vote, Votable target) {
        User targetAuthor = getAuthor(target);
        if (targetAuthor.equals(vote.getVoter())) {
            return;
        }

        int amount;
        ReputationAction action;

        if (target instanceof Answer) {
            if (vote.getType() == VoteType.UPVOTE) {
                amount = 10;
                action = ReputationAction.ANSWER_UPVOTED;
            } else {
                amount = -2;
                action = ReputationAction.ANSWER_DOWNVOTED;
            }
        } else {
            amount = vote.getType() == VoteType.UPVOTE ? 5 : -2;
            action = ReputationAction.QUESTION_UPVOTED;
        }

        if (amount != 0) {
            ReputationEvent event = new ReputationEvent("re" + nextId++, targetAuthor, action, amount,
                    target instanceof Question ? ((Question) target).getId() : ((Answer) target).getId());
            events.add(event);
            targetAuthor.updateReputation(amount);
        }

        if (vote.getType() == VoteType.DOWNVOTE) {
            ReputationEvent voterEvent = new ReputationEvent("re" + nextId++, vote.getVoter(),
                    ReputationAction.DOWNVOTE_GIVEN, -1,
                    target instanceof Question ? ((Question) target).getId() : ((Answer) target).getId());
            events.add(voterEvent);
            vote.getVoter().updateReputation(-1);
        }
    }

    @Override
    public void onAnswerAccepted(Answer answer, Question question) {
        ReputationEvent event = new ReputationEvent("re" + nextId++, answer.getAuthor(),
                ReputationAction.ANSWER_ACCEPTED, 15, question.getId());
        events.add(event);
        answer.getAuthor().updateReputation(15);
    }

    private User getAuthor(Votable target) {
        if (target instanceof Question) {
            return ((Question) target).getAuthor();
        }
        return ((Answer) target).getAuthor();
    }

    public List<ReputationEvent> getEvents() {
        return new ArrayList<>(events);
    }
}
