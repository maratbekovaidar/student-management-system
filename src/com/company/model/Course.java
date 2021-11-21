package com.company.model;

public class Course {
    private Integer id;
    private String name;
    private Integer credits;

    public Course(Integer id, String name, Integer credits) {
        this.id = id;
        this.name = name;
        this.credits = credits;
    }

    public Course(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }
}
