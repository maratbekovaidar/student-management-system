package com.company.service;


import java.util.Scanner;

public class MenuService {
    StudentsServiceImplementation studentsServiceImplementation = new StudentsServiceImplementation();
    CourseService courseService = new CourseServiceImplementation();
    StudentScoreService studentScoreService = new StudentScoreServiceImpl();
    Scanner in = new Scanner(System.in);

    public MenuService() {
        starter();
    }

    public void starter() {

        int cmd;

        System.out.println();
        String leftAlignFormat = "| %-6s | %-62s |%n";
        String[][] commands = new String[10][2];

        commands[0][0] = "1";
        commands[0][1] = "To Open Students management module";
        commands[1][0] = "2";
        commands[1][1] = "To Open Course management module";
        commands[2][0] = "3";
        commands[2][1] = "To Open Course score information management module";
        commands[3][0] = "4";
        commands[3][1] = "To open documentation";
        commands[4][0] = "0";
        commands[4][1] = "To close program";

        System.out.format("+--------------------------------MAIN MENU--------------------------------+%n");
        System.out.format("+--------+----------------------------------------------------------------+%n");
        System.out.format("|   ID   |                            Command                             |%n");
        System.out.format("+--------+----------------------------------------------------------------+%n");
        for (int i = 0; i < 5; i++) {
            System.out.format(leftAlignFormat, commands[i][0],commands[i][1]);
        }
        System.out.format("+--------+----------------------------------------------------------------+%n");
        System.out.println();
        System.out.println("Enter number to Select Command:");
        cmd = in.nextInt();

        switch (cmd) {
            case 1:
                studentsModel();
            case 2:
                courseModel();
            case 3:
                courseScoreModule();
            case 4:
                documentation();
            case 0:
                System.out.println("Goodbye!");
                System.exit(0);
            default:
                System.out.println("Incorrect command! Please again");
                starter();
        }

    }

    public void studentsModel() {
        int cmd;

        System.out.println();
        String leftAlignFormat = "| %-6s | %-64s |%n";
        String[][] commands = new String[10][2];

        commands[0][0] = "1";
        commands[0][1] = "To Get student information";
        commands[1][0] = "2";
        commands[1][1] = "To Add students to data";
        commands[2][0] = "3";
        commands[2][1] = "To Delete student from data";
        commands[3][0] = "4";
        commands[3][1] = "To Update students info from data";
        commands[4][0] = "5";
        commands[4][1] = "To Get all students and get backup_students file with information";
        commands[5][0] = "0";
        commands[5][1] = "To Go Main menu";

        System.out.println("Students Management Module Menu");
        System.out.format("+--------+------------------------------------------------------------------+%n");
        System.out.format("|   ID   |                              Command                             |%n");
        System.out.format("+--------+------------------------------------------------------------------+%n");
        for (int i = 0; i < 6; i++) {
            System.out.format(leftAlignFormat, commands[i][0],commands[i][1]);
        }
        System.out.format("+--------+----------------------------------------------------------------+%n");
        System.out.println();
        System.out.println("Enter number to Select Command:");
        cmd = in.nextInt();
        switch (cmd) {
            case 1:
                studentsServiceImplementation.get();
                studentsModel();
                break;
            case 2:
                studentsServiceImplementation.set();
                studentsModel();
                break;
            case 3:
                studentsServiceImplementation.delete();
                studentsModel();
                break;
            case 4:
                studentsServiceImplementation.update();
                studentsModel();
                break;
            case 5:
                studentsServiceImplementation.getAll();
                studentsModel();
                break;
            case 0:
                starter();
                System.exit(0);
                break;
            default:
                System.out.println("Incorrect command! Please again");
                studentsModel();
        }
    }

    public void courseModel() {
        int cmd;

        System.out.println();
        String leftAlignFormat = "| %-6s | %-62s |%n";
        String[][] commands = new String[10][2];

        commands[0][0] = "1";
        commands[0][1] = "To Get Course information";
        commands[1][0] = "2";
        commands[1][1] = "To Get Add course to data";
        commands[2][0] = "3";
        commands[2][1] = "To Delete course from data";
        commands[3][0] = "4";
        commands[3][1] = "To Update course info from data";
        commands[4][0] = "5";
        commands[4][1] = "To Get all course and get backup_students file with information";
        commands[5][0] = "0";
        commands[5][1] = "To Go Main menu";

        System.out.println("Course Management Module Menu");
        System.out.format("+--------+----------------------------------------------------------------+%n");
        System.out.format("|   ID   |                            Command                             |%n");
        System.out.format("+--------+----------------------------------------------------------------+%n");
        for (int i = 0; i < 6; i++) {
            System.out.format(leftAlignFormat, commands[i][0],commands[i][1]);
        }
        System.out.format("+--------+----------------------------------------------------------------+%n");
        System.out.println();
        System.out.println("Enter number to Select Command:");
        cmd = in.nextInt();
        switch (cmd) {
            case 1:
                courseService.get();
                courseModel();
                break;
            case 2:
                courseService.setCourse();
                courseModel();
                break;
            case 3:
                courseService.deleteCourse();
                courseModel();
                break;
            case 4:
                courseService.updateCourse();
                courseModel();
                break;
            case 5:
                courseService.getAllCourse();
                courseModel();
                break;
            case 0:
                starter();
                System.exit(0);
                break;
            default:
                System.out.println("Incorrect command! Please again");
                courseModel();
        }
    }

    public void courseScoreModule() {
        int cmd;

        System.out.println();
        String leftAlignFormat = "| %-6s | %-86s |%n";
        String[][] commands = new String[10][2];

        commands[0][0] = "1";
        commands[0][1] = "To Get student information about of course";
        commands[1][0] = "2";
        commands[1][1] = "To Add student's course information to data";
        commands[2][0] = "3";
        commands[2][1] = "To Delete student's course score from data";
        commands[3][0] = "4";
        commands[3][1] = "To Update student's course info from data";
        commands[4][0] = "5";
        commands[4][1] = "To Get all student's course information and get backup_students file with information";
        commands[5][0] = "0";
        commands[5][1] = "To Go Main menu";

        System.out.println("Students Score Management Module Menu");
        System.out.format("+--------+----------------------------------------------------------------------------------------+%n");
        System.out.format("|   ID   |                                      Command                                           |%n");
        System.out.format("+--------+----------------------------------------------------------------------------------------+%n");
        for (int i = 0; i < 6; i++) {
            System.out.format(leftAlignFormat, commands[i][0],commands[i][1]);
        }
        System.out.format("+--------+----------------------------------------------------------------------------------------+%n");
        System.out.println();
        System.out.println("Enter number to Select Command:");
        cmd = in.nextInt();
        switch (cmd) {
            case 1:
                studentScoreService.getScore();
                courseScoreModule();
                break;
            case 2:
                studentScoreService.addScore();
                courseScoreModule();
                break;
            case 3:
                studentScoreService.deleteScore();
                courseScoreModule();
                break;
            case 4:
                studentScoreService.updateScore();
                courseScoreModule();
                break;
            case 5:
                studentScoreService.getAllScores();
                courseScoreModule();
                break;
            case 0:
                starter();
                System.exit(0);
                break;
            default:
                System.out.println("Incorrect command! Please again");
                courseScoreModule();
        }
    }

    public void documentation() {
        System.out.println("In this project use MVC architecture patterns");
        System.out.println("So, firstly in model directory have classes that model of our objects");
        System.out.println("And have services that implement our models. In this classes have all functions");
        System.out.println("And in MenuService class that constructed with using Facade pattern");
        System.out.println("and this class navigate us to services when choose!");
        System.out.println("In services directory have interfaces and classes those implemented his");
    }
}
