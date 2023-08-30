package com.spoj.online_judge.Problem.Entity;

import jakarta.persistence.*;

@Entity
public class Problem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "problem_id")
    private int id;
    @Column(name = "contest_id")
    private int contestId;
    @Column(name = "title")
    private String title;
    @Column(name = "description", columnDefinition = "text")
    private String description;
    @Column(name = "example1_input")
    private String example1input;
    @Column(name = "example1_output")
    private String example1output;
    @Column(name = "example2_input")
    private String example2input;
    @Column(name = "example2_output")
    private String example2output;

    @Column(name="boiler_code_python", columnDefinition = "text")
    private String boiler_code_python;

    @Column(name="boiler_code_java", columnDefinition = "text")
    private String boiler_code_java;

    @Column(name="boiler_code_cpp", columnDefinition = "text")
    private String boiler_code_cpp;


    public Problem(int contestId, String title, String description, String example1input, String example1output, String example2input, String example2output, String boiler_code_python, String boiler_code_java, String boiler_code_cpp) {
        this.contestId = contestId;
        this.title = title;
        this.description = description;
        this.example1input = example1input;
        this.example1output = example1output;
        this.example2input = example2input;
        this.example2output = example2output;
        this.boiler_code_python = boiler_code_python;
        this.boiler_code_java = boiler_code_java;
        this.boiler_code_cpp = boiler_code_cpp;
    }

    public Problem(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getContestId() {
        return contestId;
    }

    public void setContestId(int contestId) {
        this.contestId = contestId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExample1input() {
        return example1input;
    }

    public void setExample1input(String example1input) {
        this.example1input = example1input;
    }

    public String getExample1output() {
        return example1output;
    }

    public void setExample1output(String example1output) {
        this.example1output = example1output;
    }

    public String getExample2input() {
        return example2input;
    }

    public void setExample2input(String example2input) {
        this.example2input = example2input;
    }

    public String getExample2output() {
        return example2output;
    }

    public void setExample2output(String example2output) {
        this.example2output = example2output;
    }

    public String getBoiler_code_python() {
        return boiler_code_python;
    }

    public void setBoiler_code_python(String boiler_code_python) {
        this.boiler_code_python = boiler_code_python;
    }

    public String getBoiler_code_java() {
        return boiler_code_java;
    }

    public void setBoiler_code_java(String boiler_code_java) {
        this.boiler_code_java = boiler_code_java;
    }

    public String getBoiler_code_cpp() {
        return boiler_code_cpp;
    }

    public void setBoiler_code_cpp(String boiler_code_cpp) {
        this.boiler_code_cpp = boiler_code_cpp;
    }

    @Override
    public String
    toString() {
        return "ProblemEntity{" +
                "id=" + id +
                ", contestId=" + contestId +
                ", title='" + title + '\'' +
                '}';
    }
}
