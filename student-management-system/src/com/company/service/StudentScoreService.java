package com.company.service;

import com.company.model.StudentScore;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentScoreService {
    Scanner sc = new Scanner(System.in);

    private List<StudentScore> scores = new ArrayList<>();

    public StudentScore get(Integer id){
        for (StudentScore studentScore: scores){
            if(studentScore.getStudentId() == id){
                return studentScore;
            }
        }
        return null;
    }

    public void addScore(){
        System.out.println("Please enter student ID:");
        Integer studentID = sc.nextInt();
        System.out.println("Please enter course ID:");
        Integer courseID = sc.nextInt();
        System.out.println("Please enter grades:");
        Integer score = sc.nextInt();
        if (get(studentID) != null){
            System.out.println("This score information already exist, please reconfirm the score information that needs to be added," +
                    "and return to the main interface after 5 seconds");
        }
        scores.add(new StudentScore(studentID,courseID,score));
        System.out.println("Score information successfully added!");
    }

    public void updateScore(){
        System.out.println("Please enter the student ID corresponding to the grade for which the information needs to be modified");
        Integer studentID = sc.nextInt();
        if(get(studentID) == null){
            System.out.println("Score information with this student ID does not exist");
        }
        System.out.println("Please enter the course ID corresponding to the grade for which the information needs to be modified");
        Integer courseID = sc.nextInt();
        System.out.println("Please enter the revised grade:");
        Integer score = sc.nextInt();
        StudentScore studentScore = new StudentScore(studentID,courseID,score);
        scores.remove(get(studentID));
        scores.add(studentScore);
        System.out.println("The modification is successful, return to the main interface after 5 seconds");
    }

    public void deleteScore(){
        System.out.println("Please enter the student ID corresponding to the course you want to delete");
        Integer studentid = sc.nextInt();
        System.out.println("Please enter the course ID of the course you want to delete");
        Integer courseID = sc.nextInt();
        System.out.println("Please enter the grade corresponding to the course you want to delete");
        Integer score = sc.nextInt();
        StudentScore studentScore = new StudentScore(studentid, courseID, score);
        if (get(studentid) != null){
            scores.remove(get(studentid));
            System.out.println("The grade information is successfully deleted!");
        }else{
            System.out.println("Deletion failed, please check whether the entered information is correct");
        }
        System.out.println("The deletion is over, it will return to the main interface");
    }

    public void getScore(){
        System.out.println("Please enter the student ID you want to inquire about");
        Integer studentID = sc.nextInt();
        System.out.println("Please enter the course ID corresponding to the information you want to check result");
        Integer courseID = sc.nextInt();
        if(get(studentID) != null){
            StudentScore studentScore = get(studentID);
            System.out.println("Student ID: "+studentScore.getStudentId());
            System.out.println("Course ID: "+studentScore.getCourseId());
            System.out.println("Score: "+studentScore.getScore());
            System.out.println("Query is complete");
        }else{
            System.out.println("The courseID and studentID you entered does not exist");
        }
        System.out.println("Will return to the main interface");
    }

    public void getAllScores(){
        String leftAlignFormat = "| %-6d | %-11s | %-8s |%n";
        System.out.println("All grades");
        System.out.format("+--------+-------------+----------+%n");
        System.out.format("| Student ID     | Course ID   | Score    |%n");
        System.out.format("+--------+-------------+----------+%n");
        for (StudentScore studentScore : scores) {
            System.out.format(leftAlignFormat, studentScore.getStudentId(), studentScore.getCourseId(), studentScore.getScore());
        }
        System.out.format("+--------+-------------+----------+%n");
        try {
            //might to update the filename and path
            File fout = new File("src\\com\\company\\backup_scores.txt");
            FileOutputStream fstream = new FileOutputStream(fout);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fstream));

            String [] courses_info = new String[scores.size()];

            for (int i = 0; i < scores.size(); i++) {
                StudentScore studentScore = scores.get(i);
                courses_info[i] = studentScore.getStudentId()+ " " + studentScore.getCourseId() + " " + studentScore.getScore();
            }

            //please keep track of the database length
            for (int j =0; j < scores.size(); j++)
            {
                bw.write(courses_info[j]);
                bw.newLine();
            }

            bw.close();
            System.out.println("Scores information is backup in backup_scores.txt file!");
        }catch (Exception e) {
            System.err.println("Error:"+e.getMessage());
        }
    }
}
