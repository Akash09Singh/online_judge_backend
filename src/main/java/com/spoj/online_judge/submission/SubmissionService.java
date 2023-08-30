package com.spoj.online_judge.submission;

import com.spoj.online_judge.Models.SubmissionStatus;
import com.spoj.online_judge.Models.SubmitProblem;
import com.spoj.online_judge.submission.pojo.ApiResponse;
import com.spoj.online_judge.submission.pojo.UserSubmission;

import java.util.List;

public interface SubmissionService {
    Submission createSubmission(Submission submission);
    List<Submission> getSubmissionsByUserId(int userId);
    List<Submission> getSubmissionsByProblemId(int problemId);

    SubmissionStatus executeCode(Submission submission);
}
