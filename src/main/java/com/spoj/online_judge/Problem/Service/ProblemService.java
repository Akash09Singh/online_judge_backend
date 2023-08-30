package com.spoj.online_judge.Problem.Service;

import com.spoj.online_judge.Problem.Repository.ProblemRepository;
import com.spoj.online_judge.exception.customExceptiom.ProblemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import com.spoj.online_judge.Problem.Entity.Problem;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Service
public class ProblemService {
    @Autowired
    private ProblemRepository problemRepository;

    public ProblemService(ProblemRepository problemRepository) {
        this.problemRepository = problemRepository;
    }

    public List<Problem> getAllProblem(){
        return problemRepository.findAll();
    }


    public Problem getProblemById(int theId) {
        return problemRepository.findById(theId)
                .orElseThrow(() -> new ProblemNotFoundException("no problem exists with id: "+theId));
    }

    public List<Problem> getProblemByContestId(int contestId){
        return problemRepository.findByContestId(contestId);
    }

    public Problem addProblem(Problem theProblem){
        return problemRepository.save(theProblem);
    }

    public List<Problem> addAllProblem(List<Problem> allProblems){


        return problemRepository.saveAll(allProblems);
    }
}
