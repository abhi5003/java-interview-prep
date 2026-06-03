#### **Design StackOverflow**

**Requirements gathering :**
1. User can post questions/answer and comment
2. User can vote question and answer
3. Question should have associated tag
4. User can search questions based upon  keyword/tag and user profile
5. The system should assign reputation score to users based on their activity and the quality of their contributions.
6. The system should handle concurrent access and ensure data consistency.
7. The question author can mark one answer as accepted. Accepted answers appear pinned and earn a reputation bonus for the answerer.
8. Votes are either upvotes or downvotes. Each user can cast only one vote per post and cannot vote on their own content.
9. Reputation changes are triggered by specific events: +10 for receiving an upvote on an answer, +15 for having an answer accepted, +5 for an upvote on a question, -2 for receiving a downvote, -1 for downvoting an answer.

**Identify core entities** 
1. User - class
2. Question - class
3. Answer - class
4. VoteType - enum (UPVOTE, DOWNVOTE)
5. Tag/Keyword - class
6. Comment - class
7. Votable - interface (Question, Answer)
8. Commentable - interface (Question, Answer)
9. ReputationEvent - class
10. ReputationAction - enum (ANSWER_UPVOTED, ANSWER_ACCEPTED, QUESTION_UPVOTED, ANSWER_DOWNVOTED, DOWNVOTE_GIVEN)

---

## Class Diagram

```plantuml
@startuml

' ────────────────────────────────────────────────────────────────
' Enums
' ────────────────────────────────────────────────────────────────
enum VoteType {
    UPVOTE
    DOWNVOTE
}

enum ReputationAction {
    ANSWER_UPVOTED
    ANSWER_ACCEPTED
    QUESTION_UPVOTED
    ANSWER_DOWNVOTED
    DOWNVOTE_GIVEN
}

' ────────────────────────────────────────────────────────────────
' Interfaces
' ────────────────────────────────────────────────────────────────
interface Votable {
    +getVotes(): List<Vote>
    +addVote(vote: Vote): void
    +removeVote(vote: Vote): void
}

interface Commentable {
    +getComments(): List<Comment>
    +addComment(comment: Comment): void
    +removeComment(comment: Comment): void
}

' ────────────────────────────────────────────────────────────────
' Classes
' ────────────────────────────────────────────────────────────────
class User {
    -id: String
    -username: String
    -email: String
    -password: String
    -reputation: int
    -createdAt: LocalDateTime
    +updateReputation(amount: int): void
}

class Question {
    -id: String
    -title: String
    -content: String
    -createdAt: LocalDateTime
    -updatedAt: LocalDateTime
    +acceptAnswer(answer: Answer): void
}

class Answer {
    -id: String
    -content: String
    -isAccepted: boolean
    -createdAt: LocalDateTime
}

class Comment {
    -id: String
    -content: String
    -createdAt: LocalDateTime
}

class Vote {
    -id: String
    -createdAt: LocalDateTime
}

class Tag {
    -id: String
    -name: String
    -description: String
}

class ReputationEvent {
    -id: String
    -amount: int
    -sourceId: String
    -createdAt: LocalDateTime
}

' ────────────────────────────────────────────────────────────────
' Interface Implementations
' ────────────────────────────────────────────────────────────────
Votable        <|.. Question
Votable        <|.. Answer
Commentable    <|.. Question
Commentable    <|.. Answer

' ────────────────────────────────────────────────────────────────
' User Relationships
' ────────────────────────────────────────────────────────────────
User   "1" ── "*" Question         : posts
User   "1" ── "*" Answer           : posts
User   "1" ── "*" Comment          : posts
User   "1" ── "*" Vote             : casts
User   "1" ── "*" ReputationEvent  : has

' ────────────────────────────────────────────────────────────────
' Question Relationships
' ────────────────────────────────────────────────────────────────
Question  "1" ── "*"    Answer          : has
Question  "1" ── "0..1" Answer          : accepted
Question  "*" ── "*"    Tag             : tagged with

' ────────────────────────────────────────────────────────────────
' Vote & Comment (Polymorphic via Interfaces)
' ────────────────────────────────────────────────────────────────
Vote        "*" ── "1" Votable        : targets
Comment     "*" ── "1" Commentable    : belongs to

' ────────────────────────────────────────────────────────────────
' Enum References
' ────────────────────────────────────────────────────────────────
Vote             "*" ── "1" VoteType
ReputationEvent  "*" ── "1" ReputationAction

@enduml
```