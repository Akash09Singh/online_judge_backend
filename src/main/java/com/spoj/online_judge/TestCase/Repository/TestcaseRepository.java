package com.spoj.online_judge.TestCase.Repository;

import com.spoj.online_judge.TestCase.Entity.Testcase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestcaseRepository extends JpaRepository<Testcase, Integer> {
    List<Testcase> findByProblemId(int problemId);
}
