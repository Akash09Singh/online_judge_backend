package com.spoj.online_judge.TestCase.Service;

import com.spoj.online_judge.TestCase.Entity.Testcase;
import com.spoj.online_judge.TestCase.Repository.TestcaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestcaseService {
    @Autowired
    private TestcaseRepository testcaseRepository;


    public Testcase createTestcase(Testcase testcase) {
        return testcaseRepository.save(testcase);
    }


    public List<Testcase> getTestcasesByProblemId(int problemId) {
        return testcaseRepository.findByProblemId(problemId);
    }

    // Implement other methods as needed
    public List<Testcase> getAll(){
        return testcaseRepository.findAll();
    }
}



