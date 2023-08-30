package com.spoj.online_judge.docker;
import org.springframework.stereotype.Service;
import java.io.File;
import java.io.IOException;
import java.time.Duration;


@Service
public class DockerManager{
    public void buildCppDocker(){


        try {
            // Define the batch command to be executed
            String command = "buildCppImage.bat"; // Example: "dir" is the command to list files in the current directory

            // Create a ProcessBuilder instance with the command
            System.out.println("executing bat file");
            ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe","/c","C:\\Users\\ASUS\\Desktop\\online_judge\\online_judge_backend\\src\\main\\java\\com\\spoj\\online_judge\\docker\\buildCppImage.bat");
            processBuilder.directory(new File("C:\\Users\\ASUS\\Desktop\\online_judge\\online_judge_backend\\src\\main\\java\\com\\spoj\\online_judge\\docker"));

            // Redirect error stream to output stream
            processBuilder.redirectErrorStream(true);

            // Start the process
            Process process = processBuilder.start();

            // Read the output of the process
            java.io.InputStream inputStream = process.getInputStream();
            java.util.Scanner scanner = new java.util.Scanner(inputStream).useDelimiter("\\A");
            String output = scanner.hasNext() ? scanner.next() : "";

            // Print the output
            System.out.println(output);

            // Wait for the process to complete
            int exitCode = process.waitFor();
            System.out.println("Exit code: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }

   //class to build java docker
   public void buildJavaDocker(){


       try {
           // Define the batch command to be executed
           String command = "buildJavaImage.bat"; // Example: "dir" is the command to list files in the current directory

           // Create a ProcessBuilder instance with the command
           ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe","/c","C:\\Users\\akash\\OneDrive\\Desktop\\online_judge\\online_judge_4\\src\\main\\java\\com\\spoj\\online_judge\\docker\\buildJavaImage.bat");
           processBuilder.directory(new File("C:\\Users\\akash\\OneDrive\\Desktop\\online_judge\\online_judge_4\\src\\main\\java\\com\\spoj\\online_judge\\docker"));

           // Redirect error stream to output stream
           processBuilder.redirectErrorStream(true);

           // Start the process
           Process process = processBuilder.start();

           // Read the output of the process
           java.io.InputStream inputStream = process.getInputStream();
           java.util.Scanner scanner = new java.util.Scanner(inputStream).useDelimiter("\\A");
           String output = scanner.hasNext() ? scanner.next() : "";

           // Print the output
           System.out.println(output);

           // Wait for the process to complete
           int exitCode = process.waitFor();
           System.out.println("Exit code: " + exitCode);
       } catch (IOException | InterruptedException e) {
           e.printStackTrace();
       }

   }

   //method to build python docker
   public void buildPythonDocker(){


       try {
           // Define the batch command to be executed
           String command = "buildCppImage.bat"; // Example: "dir" is the command to list files in the current directory

           // Create a ProcessBuilder instance with the command
           ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe","/c","C:\\Users\\akash\\OneDrive\\Desktop\\online_judge\\online_judge_4_backup\\src\\main\\java\\com\\spoj\\online_judge\\docker\\buildPythonImage.bat");
           processBuilder.directory(new File("C:\\Users\\akash\\OneDrive\\Desktop\\online_judge\\online_judge_4_backup\\src\\main\\java\\com\\spoj\\online_judge\\docker"));

           // Redirect error stream to output stream
           processBuilder.redirectErrorStream(true);

           // Start the process
           Process process = processBuilder.start();

           // Read the output of the process
           java.io.InputStream inputStream = process.getInputStream();
           java.util.Scanner scanner = new java.util.Scanner(inputStream).useDelimiter("\\A");
           String output = scanner.hasNext() ? scanner.next() : "";

           // Print the output
           System.out.println(output);

           // Wait for the process to complete
           int exitCode = process.waitFor();
           System.out.println("Exit code: " + exitCode);
       } catch (IOException | InterruptedException e) {
           e.printStackTrace();
       }

   }



}
