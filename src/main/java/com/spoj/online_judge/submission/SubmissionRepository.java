package com.spoj.online_judge.submission;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubmissionRepository extends JpaRepository<Submission, Integer> {
    List<Submission> findByUserId(int userId);
    List<Submission> findByProblemId(int problemId);
}
