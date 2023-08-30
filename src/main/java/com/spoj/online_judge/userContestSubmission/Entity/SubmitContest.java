package com.spoj.online_judge.userContestSubmission.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "submit_contest")
public class SubmitContest {
    @Column(name = "contest_submit_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int submitContestId;

    @Column(name = "user_id")
    private int userId;

    @Column(name="contest_name")
    private String contestName;

    @Column(name="time_taken")
    private String timeTaken;

    @Column(name = "solved_question")
    private int solvedQuestion;

    @Column(name = "total_time")
    private String totalTime;

    @Column(name="total_question")
    private int totalQuestion;

    @Column(name="language")
    private String language;

    public SubmitContest() {
    }

    public SubmitContest(String contestName, String timeTaken, int solvedQuestion, String totalTime, int totalQuestion, String language) {
        this.contestName = contestName;
        this.timeTaken = timeTaken;
        this.solvedQuestion = solvedQuestion;
        this.totalTime = totalTime;
        this.totalQuestion = totalQuestion;
        this.language=language;
    }

    public int getSubmitContestId() {
        return submitContestId;
    }

    public void setSubmitContestId(int submitContestId) {
        this.submitContestId = submitContestId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getContestName() {
        return contestName;
    }

    public void setContestName(String contestName) {
        this.contestName = contestName;
    }

    public String getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(String timeTaken) {
        this.timeTaken = timeTaken;
    }

    public int getSolvedQuestion() {
        return solvedQuestion;
    }

    public void setSolvedQuestion(int solvedQuestion) {
        this.solvedQuestion = solvedQuestion;
    }

    public String getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime;
    }

    public int getTotalQuestion() {
        return totalQuestion;
    }

    public void setTotalQuestion(int totalQuestion) {
        this.totalQuestion = totalQuestion;
    }
}
