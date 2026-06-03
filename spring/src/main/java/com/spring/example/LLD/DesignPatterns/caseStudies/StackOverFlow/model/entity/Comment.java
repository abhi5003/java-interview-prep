package com.spring.example.LLD.DesignPatterns.caseStudies.StackOverFlow.model.entity;

import java.time.LocalDateTime;

import com.spring.example.LLD.DesignPatterns.caseStudies.StackOverFlow.model.contract.Commentable;

public class Comment {
    private String id;
    private String content;
    private User author;
    private Commentable target;
    private LocalDateTime createdAt;

    public Comment(String id, String content, User author, Commentable target) {
        this.id = id;
        this.content = content;
        this.author = author;
        this.target = target;
        this.createdAt = LocalDateTime.now();
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

    public Commentable getTarget() {
        return target;
    }

    public void setTarget(Commentable target) {
        this.target = target;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
