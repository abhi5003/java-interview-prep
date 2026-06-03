package com.spring.example.LLD.DesignPatterns.caseStudies.StackOverFlow.model;

import java.util.List;

public interface Commentable {
    List<Comment> getComments();
    void addComment(Comment comment);
    void removeComment(Comment comment);
}
