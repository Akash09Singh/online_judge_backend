package com.spoj.online_judge.Contest.Service;

import com.spoj.online_judge.Contest.Entity.Contest;
import com.spoj.online_judge.Contest.Repository.ContestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ContestService {
    @Autowired
    private ContestRepository contestRepository;

    public ContestService(ContestRepository contestRepository) {
        this.contestRepository = contestRepository;
    }

    public Contest createContest(Contest contest){
        Contest createdContest = contestRepository.save(contest);
        return createdContest;
    }

    public Contest getContestById(int theId){
        return contestRepository.findById(theId).orElseThrow(()-> new RuntimeException("Contest not found with Id "+theId));
    }

    public List<Contest> getAllContest(){
        return contestRepository.findAll();
    }
}
