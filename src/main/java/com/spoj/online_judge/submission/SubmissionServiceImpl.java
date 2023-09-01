package com.spoj.online_judge.submission;

import com.spoj.online_judge.Models.SubmissionStatus;
import com.spoj.online_judge.Problem.Entity.Problem;
import com.spoj.online_judge.Problem.Service.ProblemService;
import com.spoj.online_judge.TestCase.Entity.Testcase;
import com.spoj.online_judge.TestCase.Service.TestcaseService;
import com.spoj.online_judge.docker.DockerManager;
import com.spoj.online_judge.submission.pojo.ApiResponse;
import com.spoj.online_judge.submission.pojo.UserSubmission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.io.FileWriter;
import java.io.IOException;


//import static jdk.internal.org.jline.utils.Log.error;

@Service
//@Slf4j
public class SubmissionServiceImpl implements SubmissionService {

    private static final String url = "https://code-compiler10.p.rapidapi.com/";
    private static final String xRapidApiKey = "497db9c8bamsh59562a9c7b35789p1c8294jsn2b471b7c33e0";
    private static final String xRapidApiHost =  "code-compiler10.p.rapidapi.com";

    private static final List<String> langEnum = new ArrayList<>(Arrays.asList("php", "python", "c", "c_cpp", "csharp", "kotlin", "golang",
            "r", "java", "typescript", "nodejs", "ruby", "perl", "swift", "fortran", "bash"));



    @Autowired
    private SubmissionRepository submissionRepository;

    @Autowired
    private TestcaseService testcaseService;

    @Autowired
    private ProblemService problemService;
    @Autowired
    DockerManager dockerManager;



    @Override
    public Submission createSubmission(Submission submission) {
        return submissionRepository.save(submission);
    }

    @Override
    public List<Submission> getSubmissionsByUserId(int userId) {
        return submissionRepository.findByUserId(userId);
    }

    @Override
    public List<Submission> getSubmissionsByProblemId(int problemId) {
        return submissionRepository.findByProblemId(problemId);
    }
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public SubmissionStatus executeCode(Submission submission) {
        //do preprocessing
        Problem problem  = problemService.getProblemById(submission.getProblemId());
        List<Testcase> testcases = testcaseService.getTestcasesByProblemId(submission.getProblemId());
        UserSubmission userSubmission = new UserSubmission();
        userSubmission.setLangEnum(langEnum);
        userSubmission.setCode(submission.getCode());
        createCppFile(submission.getCode());
        saveTestcaseToFile(testcases);
        userSubmission.setLang("c_cpp");
        System.out.println(problem.getBoiler_code_python());
        try{
            dockerManager.buildCppDocker();
            String codeOutputPath = "C:\\Users\\ASUS\\Desktop\\online_judge\\online_judge_backend\\src\\main\\java\\com\\spoj\\online_judge\\docker\\code\\outputCode.txt";
            String outputPath = "C:\\Users\\ASUS\\Desktop\\online_judge\\online_judge_backend\\src\\main\\java\\com\\spoj\\online_judge\\docker\\code\\output.txt";
            String status = compareFiles(codeOutputPath, outputPath);
            return new SubmissionStatus(status);
        }catch (Exception e){
            System.out.println("exception while calling rapid api");
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "exception while calling rapid api", e);
        }

    }





    // Implement other methods as needed
    public String createCppFile(String code){
        try{
        String filepath = "C:\\Users\\ASUS\\Desktop\\online_judge\\online_judge_backend\\src\\main\\java\\com\\spoj\\online_judge\\docker\\code\\Submit.cpp";
        FileWriter writer = new FileWriter(filepath);
        writer.write(code);
        writer.close();
        return "file created Successfully";

        }
        catch (IOException e){
            e.printStackTrace();
            return "error creating file";

        }

    }

    public String saveTestcaseToFile(List<Testcase> testcases){
        try{
            String inputFilepath = "C:\\Users\\ASUS\\Desktop\\online_judge\\online_judge_backend\\src\\main\\java\\com\\spoj\\online_judge\\docker\\code\\input.txt";
            FileWriter inputWriter = new FileWriter(inputFilepath);
            String outputFilepath = "C:\\Users\\ASUS\\Desktop\\online_judge\\online_judge_backend\\src\\main\\java\\com\\spoj\\online_judge\\docker\\code\\output.txt";
            FileWriter outputWriter = new FileWriter(outputFilepath);
            if(testcases.size()>0){
                inputWriter.write(testcases.size()+"\n");
            }
            for(Testcase testcase:testcases){
                String[] tc = testcase.getInput().split("\n");
                for(String in:tc){
                    inputWriter.write(in+"\n");
                }
                outputWriter.write(testcase.getExpectedOutput()+"\n");
            }
            inputWriter.close();
            outputWriter.close();
            return "input and outfile created successfully";
        }catch (IOException e){
            e.printStackTrace();
            return "error  creating testcase file ";
        }
    }

    public static String compareFiles(String file1Path, String file2Path) {
        try (BufferedReader reader1 = new BufferedReader(new FileReader(file1Path));
             BufferedReader reader2 = new BufferedReader(new FileReader(file2Path))) {

            String line1, line2;
            while ((line1 = reader1.readLine()) != null && (line2 = reader2.readLine()) != null) {
                if (!line1.trim().equals(line2.trim())) {
                    return "Rejected";
                }
            }

            // Check if both files have the same number of lines
            if (reader1.readLine() != null || reader2.readLine() != null) {
                return "Rejected";
            }

            return "Accepted";
        } catch (IOException e) {
            e.printStackTrace();
            return "Error";
        }
    }

}
