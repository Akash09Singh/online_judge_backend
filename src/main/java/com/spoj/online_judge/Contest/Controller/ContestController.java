package com.spoj.online_judge.Contest.Controller;

import com.spoj.online_judge.Contest.Entity.Contest;
import com.spoj.online_judge.Contest.Service.ContestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/contest")
public class ContestController {
    private ContestService contestService;

    public ContestController(ContestService contestService) {
        this.contestService = contestService;
    }


    @GetMapping
    public ResponseEntity<List<Contest>> findAllContest(){
        List<Contest> allContest = contestService.getAllContest();
        return new ResponseEntity<>(allContest, HttpStatus.OK);
    }

    @GetMapping("/{theId}")
    public ResponseEntity<Contest> findContestById(@PathVariable int theId){
        Contest theContest = contestService.getContestById(theId);
        return new ResponseEntity<>(theContest, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Contest> createContest(@RequestBody Contest contest){
        Contest createdContest = contestService.createContest(contest);
        return new ResponseEntity<>(createdContest, HttpStatus.CREATED);
    }
}
