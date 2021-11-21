package com.company.service;

import com.company.model.Course;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.*;

public class CourseServiceImplementation implements CourseService {
    Scanner sc = new Scanner(System.in);
    List<Course> courses = new ArrayList<>();

    public Course getCourse(int id){
        for(Course course : courses)
        {
            if(course.getId() == id){
                return course;
            }
        }
        return null;
    }

    @Override
    public void get() {
        int id;
        System.out.println("Input course's id: ");
        id = sc.nextInt();
        if (getCourse(id) != null) {
            System.out.println("Course's ID: " + Objects.requireNonNull(getCourse(id)).getId());
            System.out.println("Course's Name: " + Objects.requireNonNull(getCourse(id)).getName());
            System.out.println("Course's Credits: " + Objects.requireNonNull(getCourse(id)).getCredits());
        } else {
            System.out.println("Course that have " + id + " ID don't exist");
        }
    }

    @Override
    public void setCourse(){
        System.out.println("Please enter the courseID:");
        Integer id = sc.nextInt();
        if (getCourse(id) == null){
            System.out.println("Please enter the course name:");
            String name = sc.next();
            System.out.println("Please enter course credit:");
            Integer credit = sc.nextInt();
            courses.add(new Course(id,name,credit));
            System.out.println("Course successfully added!");
        }else{
        System.out.println("Course already exist, please reconfirm the course information that needs to be added," +
                "and return to the main interface after 5 seconds");
        }
    }

    @Override
    public void updateCourse(){
        System.out.println("Please enter the courseID whose information needs to be modified");
        Integer id = sc.nextInt();
        if(getCourse(id) == null){
            System.out.println("Course with this ID does not exist");
        }
        System.out.println("Please enter the revised course name:");
        String name = sc.next();
        System.out.println("Please enter the revised course credit:");
        Integer credit = sc.nextInt();
        Course course = new Course(id,name,credit);
        courses.remove(getCourse(id));
        courses.add(course);
        System.out.println("The modification is successful, return to the main interface after 5 seconds");
    }

    @Override
    public void deleteCourse(){
        System.out.println("Please enter the courseID corresponding to the course you want to delete");
        Integer id = sc.nextInt();
        System.out.println("Please enter the name of the course you want to delete");
        String name = sc.next();
        System.out.println("Please enter the credit corresponding to the course you want to delete");
        Integer credits = sc.nextInt();
        Course course = new Course(id, name, credits);
        if (getCourse(id) != null){
            courses.remove(getCourse(id));
            System.out.println("Course "+name+" successfully deleted!");
        }else{
            System.out.println("Deletion failed, please check whether the entered information is correct");
        }
    }

    @Override
    public void getAllCourse(){
        String leftAlignFormat = "| %-6d | %-11s | %-8s |%n";
        System.out.println("All courses");
        System.out.format("+--------+-------------+----------+%n");
        System.out.format("| ID     | Name        | Credits   |%n");
        System.out.format("+--------+-------------+----------+%n");
        for (Course course : courses) {
            System.out.format(leftAlignFormat, course.getId(), course.getName(), course.getCredits());
        }
        System.out.format("+--------+-------------+----------+%n");
        try {
            //might to update the filename and path
            File fout = new File("src\\com\\company\\backup_courses.txt");
            FileOutputStream fstream = new FileOutputStream(fout);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fstream));

            String [] courses_info = new String[courses.size()];

            for (int i = 0; i < courses.size(); i++) {
                Course course = courses.get(i);
                courses_info[i] = course.getId() + " " + course.getName() + " " + course.getCredits();
            }

            //please keep track of the database length
            for (int j =0; j < courses.size(); j++)
            {
                bw.write(courses_info[j]);
                bw.newLine();
            }

            bw.close();
            System.out.println("Courses information is backup in backup_courses.txt file!");
        }catch (Exception e) {
            System.err.println("Error:"+e.getMessage());
        }
    }
}
