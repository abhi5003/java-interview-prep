package com.spring.example.LLD.DesignPatterns.caseStudies.StackOverFlow.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Answer implements Votable, Commentable {
    private String id;
    private String content;
    private User author;
    private boolean isAccepted;
    private List<Vote> votes;
    private List<Comment> comments;
    private LocalDateTime createdAt;

    public Answer(String id, String content, User author) {
        this.id = id;
        this.content = content;
        this.author = author;
        this.isAccepted = false;
        this.votes = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.createdAt = LocalDateTime.now();
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
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
}
