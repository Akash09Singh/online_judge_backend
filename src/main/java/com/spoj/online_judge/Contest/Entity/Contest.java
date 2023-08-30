package com.spoj.online_judge.Contest.Entity;

import jakarta.persistence.*;

import java.sql.Time;
import java.util.Date;

@Entity
public class Contest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contest_id")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "end_time")
    private Time endTime;

    public Contest(String title, Time endTime) {
        this.title = title;
        this.endTime = endTime;
    }
    public Contest(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Contest{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", endTime=" + endTime +
                '}';
    }
}
