package com.spring.example.LLD.DesignPatterns.caseStudies.StackOverFlow.demo;

import java.util.*;
import java.util.stream.Collectors;

import com.spring.example.LLD.DesignPatterns.caseStudies.StackOverFlow.model.contract.Commentable;
import com.spring.example.LLD.DesignPatterns.caseStudies.StackOverFlow.model.contract.ReputationObserver;
import com.spring.example.LLD.DesignPatterns.caseStudies.StackOverFlow.model.contract.Votable;
import com.spring.example.LLD.DesignPatterns.caseStudies.StackOverFlow.model.entity.*;
import com.spring.example.LLD.DesignPatterns.caseStudies.StackOverFlow.model.enums.VoteType;
import com.spring.example.LLD.DesignPatterns.caseStudies.StackOverFlow.service.ReputationManager;

public class StackOverflowDemo {

    private List<User> users = new ArrayList<>();
    private List<Question> questions = new ArrayList<>();
    private List<Answer> answers = new ArrayList<>();
    private List<Tag> tags = new ArrayList<>();
    private List<ReputationObserver> observers = new ArrayList<>();
    private int nextId = 1;

    public void attachObserver(ReputationObserver observer) {
        observers.add(observer);
    }

    public void detachObserver(ReputationObserver observer) {
        observers.remove(observer);
    }

    private void notifyVoteCast(Vote vote, Votable target) {
        for (ReputationObserver o : observers) {
            o.onVoteCast(vote, target);
        }
    }

    private void notifyAnswerAccepted(Answer answer, Question question) {
        for (ReputationObserver o : observers) {
            o.onAnswerAccepted(answer, question);
        }
    }

    public User createUser(String username, String email, String password) {
        String id = "u" + nextId++;
        User user = new User(id, username, email, password);
        users.add(user);
        return user;
    }

    public Tag createTag(String name, String description) {
        String id = "t" + nextId++;
        Tag tag = new Tag(id, name, description);
        tags.add(tag);
        return tag;
    }

    public Question postQuestion(String title, String content, User author, List<Tag> questionTags) {
        String id = "q" + nextId++;
        Question question = new Question(id, title, content, author, questionTags);
        questions.add(question);
        return question;
    }

    public Answer postAnswer(String content, User author, Question question) {
        String id = "a" + nextId++;
        Answer answer = new Answer(id, content, author);
        question.addAnswer(answer);
        answers.add(answer);
        return answer;
    }

    public Comment addComment(String content, User author, Commentable target) {
        String id = "c" + nextId++;
        Comment comment = new Comment(id, content, author, target);
        target.addComment(comment);
        return comment;
    }

    public boolean castVote(User voter, Votable target, VoteType type) {
        if (voter.equals(getVotableAuthor(target))) {
            System.out.println("  Cannot vote on your own " + (target instanceof Question ? "question" : "answer"));
            return false;
        }
        boolean alreadyVoted = target.getVotes().stream().anyMatch(v -> v.getVoter().equals(voter));
        if (alreadyVoted) {
            System.out.println("  " + voter.getUsername() + " already voted on this " + (target instanceof Question ? "question" : "answer"));
            return false;
        }
        String id = "v" + nextId++;
        Vote vote = new Vote(id, voter, type, target);
        target.addVote(vote);
        notifyVoteCast(vote, target);
        return true;
    }

    public void acceptAnswer(Question question, Answer answer) {
        question.acceptAnswer(answer);
        notifyAnswerAccepted(answer, question);
    }

    private User getVotableAuthor(Votable target) {
        if (target instanceof Question) {
            return ((Question) target).getAuthor();
        }
        return ((Answer) target).getAuthor();
    }

    public List<Question> searchByTag(Tag tag) {
        return questions.stream()
                .filter(q -> q.getTags().contains(tag))
                .collect(Collectors.toList());
    }

    public List<Question> searchByKeyword(String keyword) {
        String lower = keyword.toLowerCase();
        return questions.stream()
                .filter(q -> q.getTitle().toLowerCase().contains(lower) || q.getContent().toLowerCase().contains(lower))
                .collect(Collectors.toList());
    }

    public List<Question> searchByUser(User user) {
        return questions.stream()
                .filter(q -> q.getAuthor().equals(user))
                .collect(Collectors.toList());
    }

    public void displayQuestion(Question q) {
        System.out.println("\n=================================================================");
        System.out.println("Q: " + q.getTitle());
        System.out.println("   " + q.getContent());
        System.out.println("   by " + q.getAuthor().getUsername() + " (reputation: " + q.getAuthor().getReputation() + ")");
        System.out.println("   tags: " + q.getTags().stream().map(Tag::getName).collect(Collectors.joining(", ")));
        System.out.println("   votes: " + q.getVotes().size() + " (score: " + calculateScore(q) + ")");
        System.out.println("   comments: " + q.getComments().size());
        if (q.getAcceptedAnswer() != null) {
            System.out.println("   [ACCEPTED ANSWER exists]");
        }

        for (Comment c : q.getComments()) {
            System.out.println("     comment by " + c.getAuthor().getUsername() + ": " + c.getContent());
        }

        for (Answer a : q.getAnswers()) {
            System.out.println("\n   --- Answer by " + a.getAuthor().getUsername() + " ---");
            System.out.println("   " + a.getContent());
            System.out.println("   accepted: " + a.isAccepted() + " | votes: " + a.getVotes().size() + " (score: " + calculateScore(a) + ")");
            for (Comment c : a.getComments()) {
                System.out.println("     comment by " + c.getAuthor().getUsername() + ": " + c.getContent());
            }
        }
        System.out.println("=================================================================\n");
    }

    private int calculateScore(Votable target) {
        return target.getVotes().stream()
                .mapToInt(v -> v.getType() == VoteType.UPVOTE ? 1 : -1)
                .sum();
    }

    public static void main(String[] args) {
        StackOverflowDemo app = new StackOverflowDemo();
        ReputationManager reputationManager = new ReputationManager();
        app.attachObserver(reputationManager);

        System.out.println("=== STACKOVERFLOW DEMO ===\n");

        User alice = app.createUser("alice", "alice@example.com", "pass123");
        User bob = app.createUser("bob", "bob@example.com", "pass456");
        User charlie = app.createUser("charlie", "charlie@example.com", "pass789");

        Tag javaTag = app.createTag("java", "Java programming language");
        Tag springTag = app.createTag("spring", "Spring framework");
        Tag designTag = app.createTag("design-patterns", "Software design patterns");

        Question q1 = app.postQuestion("What is Dependency Injection?",
                "Can someone explain DI in Spring with an example?",
                alice, Arrays.asList(javaTag, springTag));

        Question q2 = app.postQuestion("Why use Builder Pattern?",
                "When should I use Builder pattern over a constructor?",
                bob, Arrays.asList(javaTag, designTag));

        System.out.println("--- Users created: alice, bob, charlie ---");
        System.out.println("--- Tags created: java, spring, design-patterns ---");
        System.out.println("--- Questions posted ---\n");

        Answer a1 = app.postAnswer(
                "DI is when a framework passes dependencies to an object rather than the object creating them itself.",
                bob, q1);

        Answer a2 = app.postAnswer(
                "Use Builder when you have many optional parameters or need immutable objects with a readable API.",
                alice, q2);

        Answer a3 = app.postAnswer(
                "In Spring, you can use @Autowired annotation on constructors for DI.",
                charlie, q1);

        System.out.println("--- Answers posted ---\n");

        app.addComment("Great explanation!", charlie, q1);
        app.addComment("Can you show a code example?", bob, q1);
        app.addComment("This helped me understand, thanks!", bob, a1);

        System.out.println("--- Comments added ---\n");

        app.castVote(bob, q1, VoteType.UPVOTE);
        app.castVote(charlie, q1, VoteType.UPVOTE);
        app.castVote(alice, q2, VoteType.UPVOTE);
        app.castVote(alice, a1, VoteType.UPVOTE);
        app.castVote(charlie, a1, VoteType.UPVOTE);
        app.castVote(alice, a1, VoteType.UPVOTE);

        System.out.println("\n--- Votes cast ---\n");

        app.acceptAnswer(q1, a1);

        System.out.println("\n--- Answer accepted on q1 ---\n");

        System.out.println("=== SEARCH DEMOS ===\n");

        System.out.println("Search by tag 'java':");
        for (Question q : app.searchByTag(javaTag)) {
            System.out.println("  - " + q.getTitle());
        }

        System.out.println("\nSearch by keyword 'Builder':");
        for (Question q : app.searchByKeyword("Builder")) {
            System.out.println("  - " + q.getTitle());
        }

        System.out.println("\nSearch by user 'alice':");
        for (Question q : app.searchByUser(alice)) {
            System.out.println("  - " + q.getTitle());
        }

        System.out.println("\n\n=== FULL QUESTION DUMP ===\n");

        app.displayQuestion(q1);
        app.displayQuestion(q2);

        System.out.println("\n=== FINAL REPUTATIONS ===");
        for (User u : app.users) {
            System.out.println("  " + u.getUsername() + ": " + u.getReputation());
        }
        System.out.println("\n=== REPUTATION EVENTS ===");
        for (ReputationEvent e : reputationManager.getEvents()) {
            System.out.println("  " + e.getUser().getUsername() + " " + e.getAction() + " (" + e.getAmount() + ")");
        }
    }
}
