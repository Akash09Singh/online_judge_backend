package com.spoj.online_judge.submission;

import com.spoj.online_judge.Problem.Entity.Problem;
import com.spoj.online_judge.User.entity.User;
import jakarta.persistence.*;

@Entity
public class Submission {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "submission_id")
    private int submissionId;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "problem_id")
    private int problemId;
    @Column(name = "code")
    private String code;
    @Column(name = "status")
    private String status; // Accepted, Rejected, etc.

    @Column(name="language")
    private String language;

    @Column(name = "problem_title")
    private String problemTitle;



    public Submission(){}

    public Submission(int userId, int problemId, String code, String status, String language, String problemTitle) {
        this.userId = userId;
        this.problemId = problemId;
        this.code = code;
        this.status = status;
        this.language = language;
        this.problemTitle = problemTitle;

    }

    public String getProblemTitle() {
        return problemTitle;
    }

    public void setProblemTitle(String problemTitle) {
        this.problemTitle = problemTitle;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(int submissionId) {
        this.submissionId = submissionId;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Submission{" +
                "submissionId=" + submissionId +
                ", userId=" + userId +
                ", problemId=" + problemId +
                ", code='" + code + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
