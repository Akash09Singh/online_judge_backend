package com.spoj.online_judge.TestCase.Controller;

import com.spoj.online_judge.TestCase.Entity.Testcase;
import com.spoj.online_judge.TestCase.Service.TestcaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestcaseController {
    @Autowired
    private TestcaseService testcaseService;

    @PostMapping
    public ResponseEntity<Testcase> createTestcase(@RequestBody Testcase testcase) {
        Testcase createdTestcase = testcaseService.createTestcase(testcase);
        return new ResponseEntity<>(createdTestcase, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Testcase>> getTestcases() {
        List<Testcase> testcases = testcaseService.getAll();
        return new ResponseEntity<>(testcases, HttpStatus.OK);}
    @GetMapping("/problem/{problemId}")
    public ResponseEntity<List<Testcase>> getTestcasesByProblemId(@PathVariable int problemId) {
        List<Testcase> testcases = testcaseService.getTestcasesByProblemId(problemId);
        return new ResponseEntity<>(testcases, HttpStatus.OK);
    }
}
