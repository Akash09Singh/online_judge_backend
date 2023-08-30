package com.spoj.online_judge.Problem.Repository;
import com.spoj.online_judge.Problem.Entity.Problem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProblemRepository extends JpaRepository<Problem, Integer> {
    List<Problem> findByContestId(int contestId);
}
