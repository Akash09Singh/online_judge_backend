package com.spoj.online_judge.userContestSubmission.Controller;

import com.spoj.online_judge.userContestSubmission.Entity.SubmitContest;
import com.spoj.online_judge.userContestSubmission.service.SubmitContestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/user")
public class SubmitContestController {

    @Autowired
    private SubmitContestService submitContestService;
    @PostMapping("/submit-contest")
    public ResponseEntity<SubmitContest> saveContest(@RequestBody SubmitContest submitContest){
        SubmitContest contest = submitContestService.submitContest(submitContest);

        return new ResponseEntity<>(contest, HttpStatus.CREATED);
    }

    @GetMapping("/contest/{userId}")
    public ResponseEntity<List<SubmitContest>> getUserContest(@PathVariable int userId){
        List<SubmitContest> userContests = submitContestService.getUserContest(userId);
        return new ResponseEntity<>(userContests, HttpStatus.OK);
    }
}
