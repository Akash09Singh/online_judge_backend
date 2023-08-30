package com.spoj.online_judge.submission;


import com.spoj.online_judge.Models.SubmissionStatus;
import com.spoj.online_judge.Models.SubmitProblem;
import com.spoj.online_judge.submission.pojo.ApiResponse;
import com.spoj.online_judge.submission.pojo.UserSubmission;
import jakarta.persistence.Table;

import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/submissions")
@Table(name = "submission")
public class SubmissionController {

    @Autowired
    private SubmissionServiceImpl submissionServiceImpl;

    @PostMapping
    public ResponseEntity<SubmissionStatus> createSubmission(@RequestBody SubmitProblem submitProblem) {
//        Submission createdSubmission = submissionService.createSubmission(submission);
        Submission submission = new Submission();
        submission.setCode(submitProblem.getCode());
        submission.setUserId(submitProblem.getUserId());
        submission.setProblemId(submitProblem.getProblemId());
        submission.setProblemTitle(submitProblem.getProblemTitle());
        SubmissionStatus status = submissionServiceImpl.executeCode(submission);
        submission.setStatus(status.getStatus());
        submission.setLanguage(submitProblem.getLanguage());
        submissionServiceImpl.createSubmission(submission);

        return new ResponseEntity<>(status, HttpStatus.OK);
    }


    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Submission>> getSubmissionsByUserId(@PathVariable int userId) {
        List<Submission> submissions = submissionServiceImpl.getSubmissionsByUserId(userId);
        //Collections.reverse(submissions);
        return new ResponseEntity<>(submissions, HttpStatus.OK);
    }

    @GetMapping("/problem/{problemId}")
    public ResponseEntity<List<Submission>> getSubmissionsByProblemId(@PathVariable int problemId) {
        List<Submission> submissions = submissionServiceImpl.getSubmissionsByProblemId(problemId);
        return new ResponseEntity<>(submissions, HttpStatus.OK);
    }

    // Implement other endpoints for updating submissions, deleting submissions, etc. as needed.
}
