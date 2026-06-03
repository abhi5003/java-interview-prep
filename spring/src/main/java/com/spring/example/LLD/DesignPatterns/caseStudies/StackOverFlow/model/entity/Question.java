package com.spring.example.LLD.DesignPatterns.caseStudies.StackOverFlow.model.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.spring.example.LLD.DesignPatterns.caseStudies.StackOverFlow.model.contract.Commentable;
import com.spring.example.LLD.DesignPatterns.caseStudies.StackOverFlow.model.contract.Votable;

public class Question implements Votable, Commentable {
    private String id;
    private String title;
    private String content;
    private User author;
    private List<Answer> answers;
    private Answer acceptedAnswer;
    private List<Tag> tags;
    private List<Vote> votes;
    private List<Comment> comments;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Question(String id, String title, String content, User author, List<Tag> tags) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.answers = new ArrayList<>();
        this.tags = new ArrayList<>(tags);
        this.votes = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public void acceptAnswer(Answer answer) {
        if (answers.contains(answer)) {
            this.acceptedAnswer = answer;
            answer.setAccepted(true);
        }
    }

    @Override
    public List<Vote> getVotes() {
        return votes;
    }

    @Override
    public void addVote(Vote vote) {
        votes.add(vote);
    }

    @Override
    public void removeVote(Vote vote) {
        votes.remove(vote);
    }

    @Override
    public List<Comment> getComments() {
        return comments;
    }

    @Override
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    @Override
    public void removeComment(Comment comment) {
        comments.remove(comment);
    }

    public void addAnswer(Answer answer) {
        answers.add(answer);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public Answer getAcceptedAnswer() {
        return acceptedAnswer;
    }

    public void setAcceptedAnswer(Answer acceptedAnswer) {
        this.acceptedAnswer = acceptedAnswer;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
