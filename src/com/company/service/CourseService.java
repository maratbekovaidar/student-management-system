package com.company.service;

import com.company.model.Course;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CourseService {
    Scanner sc = new Scanner(System.in);
    private Map<Integer, Course> courses = new HashMap<>();

    public void setCourse(){
        System.out.println("PLease enter the number corresponding to the module you want to enter:");
        Integer numb = sc.nextInt();
        System.out.println("Please enter the courseID:");
        Integer id = sc.nextInt();
        if (courses.containsKey(id)){
            System.out.println("Course already exist, please reconfirm the course information that needs to be added," +
                    "and return to the main interface after 5 seconds");
        }
        System.out.println("Please enter the course name:");
        String name = sc.next();
        System.out.println("Please enter course credit:");
        Integer credit = sc.nextInt();
        Course course = new Course(id,name,credit);
        courses.put(course.getId(), course);
        System.out.println("Course successfully added!");
    }

    public void updateCourse(){
        System.out.println("Please enter the courseID whose information needs to be modified");
        Integer id = sc.nextInt();
        if(courses.containsKey(id)){
            System.out.println("Course with this ID does not exist");
        }
        System.out.println("Please enter the revised course name:");
        String name = sc.next();
        System.out.println("Please enter the revised course credit:");
        Integer credit = sc.nextInt();
        Course course = new Course(id,name,credit);
        courses.replace(id, course);
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
        if (courses.containsValue(course)){
            courses.remove(course.getId());
            System.out.println("Course "+name+" successfully deleted!");
        }else{
            System.out.println("Deletion failed, please check whether the entered information is correct");
        }
    }


    public void getCourse(){
        System.out.println("Please enter the courseID corresponding to the information you want to inquire about the course");
        Integer id = sc.nextInt();
        if(courses.containsKey(id)){
            Course course = courses.get(id);
            System.out.println("Course ID: "+course.getId());
            System.out.println("Course name: "+course.getName());
            System.out.println("Course credit: "+course.getCredits());
            System.out.println("Query is complete");
            System.out.println("Will return to the main interface");
        }else{
            System.out.println("The courseID you entered does not exist");
            System.out.println("Will return to the main interface");
        }
    }

    public void getAllCourse(){
        System.out.println("PLease enter the number corresponding to the module you want to enter: ");
        Integer id = sc.nextInt();
        for (Integer key : courses.keySet()){
            Course course = courses.get(key);
            System.out.println("Course ID: " + course.getId());
            System.out.println("Course name: " + course.getName());
            System.out.println("Course credit: " + course.getCredits());
        }
    }
}
