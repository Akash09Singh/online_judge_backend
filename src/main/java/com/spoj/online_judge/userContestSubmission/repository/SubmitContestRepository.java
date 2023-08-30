package com.spoj.online_judge.userContestSubmission.repository;

import com.spoj.online_judge.userContestSubmission.Entity.SubmitContest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubmitContestRepository extends JpaRepository<SubmitContest, Integer> {
    List<SubmitContest> findByUserId(int userId);
}
