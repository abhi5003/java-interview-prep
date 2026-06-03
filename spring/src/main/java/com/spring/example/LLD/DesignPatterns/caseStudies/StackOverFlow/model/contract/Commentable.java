package com.spring.example.LLD.DesignPatterns.caseStudies.StackOverFlow.model.contract;

import java.util.List;

import com.spring.example.LLD.DesignPatterns.caseStudies.StackOverFlow.model.entity.Comment;

public interface Commentable {
    List<Comment> getComments();
    void addComment(Comment comment);
    void removeComment(Comment comment);
}
