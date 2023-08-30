package com.spoj.online_judge.TestCase.Entity;

import jakarta.persistence.*;


@Entity
@Table(name = "test_case")
public class Testcase {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "testcase_id")
    private int testcaseId;

    @Column(name = "problem_id")
    private int problemId;
    @Column(name = "input")
    private String input;
    @Column(name = "expected_output")
    private String expectedOutput;

    // Constructors, Getters, and Setters
    public Testcase(){}
    public Testcase(int problemId, String input, String expectedOutput) {
        this.problemId = problemId;
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    public int getTestcaseId() {
        return testcaseId;
    }

    public void setTestcaseId(int testcaseId) {
        this.testcaseId = testcaseId;
    }

    public int getProblemId() {
        return problemId;
    }

    public void setProblemId(int problemId) {
        this.problemId = problemId;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getExpectedOutput() {
        return expectedOutput;
    }

    public void setExpectedOutput(String expectedOutput) {
        this.expectedOutput = expectedOutput;
    }

    @Override
    public String toString() {
        return "Testcase{" +
                "testcaseId=" + testcaseId +
                ", problemId=" + problemId +
                ", input='" + input + '\'' +
                ", expectedOutput='" + expectedOutput + '\'' +
                '}';
    }

    // ...
}
