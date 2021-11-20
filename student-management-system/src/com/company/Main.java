package com.company;

import com.company.service.StudentScoreService;
import com.company.service.StudentsService;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        String user;
        LoginModule loginModule = new LoginModule();
        user = loginModule.login();

        StudentScoreService studentScoreService = new StudentScoreService();
        studentScoreService.addScore();
        studentScoreService.getAllScores();
    }
}
