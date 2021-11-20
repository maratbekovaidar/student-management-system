package com.company.service;

import com.company.model.Student;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.*;

public class StudentsService {
    Scanner in = new Scanner(System.in);
    List<Student> students = new ArrayList<>();

    public StudentsService() {
        students.add(new Student(1, "Kairat", "male"));
        students.add(new Student(2, "Madina", "female"));
        students.add(new Student(3, "Aiqyn", "male"));
    }

    private Student getStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public void get() {
        int id;
        System.out.println("Input student's id: ");
        id = in.nextInt();
        if (getStudent(id) != null) {
            System.out.println("Student's ID: " + Objects.requireNonNull(getStudent(id)).getId());
            System.out.println("Student's Name: " + Objects.requireNonNull(getStudent(id)).getName());
            System.out.println("Student's Gender: " + Objects.requireNonNull(getStudent(id)).getGender());
        } else {
            System.out.println("Student that have " + id + " ID don't exist");
        }
    }

    public void set() {
        int id;
        String name;
        String gender;

        System.out.println("Please input id of student: ");
        id = in.nextInt();
        if (getStudent(id) == null) {
            System.out.println("Please input name of student: ");
            name = in.next();
            System.out.println("Please input gender of student(male/female): ");
            gender = in.next();
            students.add(new Student(id, name, gender));
        } else {
            System.out.println("Student with " + id + " ID already exist");
        }
    }

    public void delete() {
        int id;
        int id_verify;
        String name;
        String gender;
        System.out.println("Please input student' id that delete: ");
        id = in.nextInt();
        if (getStudent(id) != null) {
            System.out.println("Please need to verify student's information for delete");
            System.out.println("Please input id of student: ");
            id_verify = in.nextInt();
            System.out.println("Please input name of student: ");
            name = in.next();
            System.out.println("Please input gender of student(male/female): ");
            gender = in.next();
            if (students.remove(new Student(id_verify, name, gender))) {
                System.out.println("Student delete success!");
            } else {
                System.out.println("Student don't deleted! Information is incorrect");
            }
        }
    }

    public void getAll() {
        String leftAlignFormat = "| %-6d | %-11s | %-8s |%n";
        System.out.println("All students");
        System.out.format("+--------+-------------+----------+%n");
        System.out.format("| ID     | Name        | Gender   |%n");
        System.out.format("+--------+-------------+----------+%n");
        for (Student student : students) {
            System.out.format(leftAlignFormat, student.getId(), student.getName(), student.getGender());
        }
        System.out.format("+--------+-------------+----------+%n");

        try {
            //might to update the filename and path
            File fout = new File("src\\com\\company\\backup_students.txt");
            FileOutputStream fstream = new FileOutputStream(fout);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fstream));

            String[] students_info = new String[students.size()];

            for (int i = 0; i < students.size(); i++) {
                Student student = students.get(i);
                students_info[i] = student.getId() + " " + student.getName() + " " + student.getGender();
            }

            //please keep track of the database length
            for (int j = 0; j < students.size(); j++) {
                bw.write(students_info[j]);
                bw.newLine();
            }

            bw.close();
            System.out.println("Students information backup in backup_students.txt file!");
        } catch (Exception e) {
            System.err.println("Error:" + e.getMessage());
        }
    }


}