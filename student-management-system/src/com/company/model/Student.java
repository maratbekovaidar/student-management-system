package com.company.model;

// Student's module
public class Student {
    private Integer id;
    private String name;
    private String gender;


    // All value constructor
    public Student(Integer id, String name, String gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    // Non value constructor
    public Student() {
    }

    // getters and setters
    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }
}
