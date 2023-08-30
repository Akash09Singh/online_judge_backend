package com.spoj.online_judge.userContestSubmission.service;

import com.spoj.online_judge.userContestSubmission.Entity.SubmitContest;
import com.spoj.online_judge.userContestSubmission.repository.SubmitContestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SubmitContestService {
    @Autowired
    private SubmitContestRepository submitContestRepository;
    //get all users submitted contest
    public List<SubmitContest> getUserContest(int userId){
        return submitContestRepository.findByUserId(userId);
    }
    public SubmitContest submitContest(SubmitContest submitContest){
        return submitContestRepository.save(submitContest);
    }

}
