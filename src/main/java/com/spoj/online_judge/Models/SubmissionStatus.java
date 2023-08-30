package com.spoj.online_judge.Models;

public class SubmissionStatus {
    String status;

    public SubmissionStatus(String status) {
        this.status = status;
    }

    public SubmissionStatus() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
