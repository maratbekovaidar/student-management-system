package com.company.service;


import java.util.Scanner;

public class MenuService {
    StudentsService studentsService = new StudentsService();
    CourseService courseService = new CourseService();
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
        String leftAlignFormat = "| %-6s | %-62s |%n";
        String[][] commands = new String[10][2];

        commands[0][0] = "1";
        commands[0][1] = "To Get student information";
        commands[1][0] = "2";
        commands[1][1] = "To Get Add students to data";
        commands[2][0] = "3";
        commands[2][1] = "To To Delete student from data";
        commands[3][0] = "4";
        commands[3][1] = "To Update students info from data";
        commands[4][0] = "5";
        commands[4][1] = "To Get all students and get backup_students file with information";
        commands[5][0] = "0";
        commands[5][1] = "To Go Main menu";

        System.out.println("Students Management Module Menu");
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
                studentsService.get();
                studentsModel();
                break;
            case 2:
                studentsService.set();
                studentsModel();
                break;
            case 3:
                studentsService.delete();
                studentsModel();
                break;
            case 4:
                studentsService.update();
                studentsModel();
                break;
            case 5:
                studentsService.getAll();
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
                courseService.getCourse();
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

    }

    public void documentation() {

    }
}
