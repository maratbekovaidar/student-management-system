package com.company.service;

import com.company.model.Course;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.*;

public class CourseService {
    Scanner sc = new Scanner(System.in);
    private List<Course> courses = new ArrayList<>();

    public Course getC (Integer id){
        for(Course course : courses)
        {
            if(course.getId() == id){
                return course;
            }
        }
        return null;
    }

    public void setCourse(){
        System.out.println("Please enter the courseID:");
        Integer id = sc.nextInt();
        System.out.println("Please enter the course name:");
        String name = sc.next();
        System.out.println("Please enter course credit:");
        Integer credit = sc.nextInt();
        Course course = new Course(id,name,credit);
        if (getC(id) != null){
            System.out.println("Course already exist, please reconfirm the course information that needs to be added," +
                    "and return to the main interface after 5 seconds");
        }
        courses.add(course);
        System.out.println("Course successfully added!");
    }

    public void updateCourse(){
        System.out.println("Please enter the courseID whose information needs to be modified");
        Integer id = sc.nextInt();
        if(getC(id) == null){
            System.out.println("Course with this ID does not exist");
        }
        System.out.println("Please enter the revised course name:");
        String name = sc.next();
        System.out.println("Please enter the revised course credit:");
        Integer credit = sc.nextInt();
        Course course = new Course(id,name,credit);
        courses.set(id-1,course);
        System.out.println("The modification is successful, return to the main interface after 5 seconds");
    }

    public void deleteCourse(){
        System.out.println("Please enter the courseID corresponding to the course you want to delete");
        Integer id = sc.nextInt();
        System.out.println("Please enter the name of the course you want to delete");
        String name = sc.next();
        System.out.println("Please enter the credit corresponding to the course you want to delete");
        Integer credits = sc.nextInt();
        Course course = new Course(id, name, credits);
        if (getC(id) != null){
            courses.remove(getC(id));
            System.out.println("Course "+name+" successfully deleted!");
        }else{
            System.out.println("Deletion failed, please check whether the entered information is correct");
        }
    }


    public void getCourse(){
        System.out.println("Please enter the courseID corresponding to the information you want to inquire about the course");
        Integer id = sc.nextInt();
        if(getC(id) != null){
            Course course = getC(id);
            System.out.println("Course ID: "+course.getId());
            System.out.println("Course name: "+course.getName());
            System.out.println("Course credit: "+course.getCredits());
            System.out.println("Query is complete");
        }else{
                System.out.println("The courseID you entered does not exist");
        }
        System.out.println("Will return to the main interface");
    }


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
