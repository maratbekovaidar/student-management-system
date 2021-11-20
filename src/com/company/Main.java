package com.company;

import com.company.service.CourseService;

import java.io.*;

public class Main {
    public static void main(String[] args) {
//        String user;
//        LoginModule loginModule = new LoginModule();
//        user = loginModule.login();

        CourseService courseService = new CourseService();
        courseService.setCourse();
        courseService.getAllCourse();
    }
}
