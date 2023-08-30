package com.spoj.online_judge.Models;

public class SubmitProblem {
    int userId;
    int problemId;
    int contestId;
    String code;

    String problemTitle;

    String language;

    public SubmitProblem() {
    }

    public SubmitProblem(int userId, int problemId, int contestId, String code, String language, String problemTitle) {
        this.userId = userId;
        this.problemId = problemId;
        this.contestId = contestId;
        this.code = code;
        this.language = language;
        this.problemTitle=problemTitle;
    }

    public String getProblemTitle() {
        return problemTitle;
    }

    public void setProblemTitle(String problemTitle) {
        this.problemTitle = problemTitle;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProblemId() {
        return problemId;
    }

    public void setProblemId(int problemId) {
        this.problemId = problemId;
    }

    public int getContestId() {
        return contestId;
    }

    public void setContestId(int contestId) {
        this.contestId = contestId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String lang) {
        this.language = lang;
    }
}
