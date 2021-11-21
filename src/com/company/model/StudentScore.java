package com.company.model;


// Model of Student's scores class
public class StudentScore {
    // base parameters
    private Integer studentId;
    private Integer courseId;
    private Integer score;

    // Constructor with all parameters
    public StudentScore(Integer studentId, Integer courseId, Integer score) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.score = score;
    }

    // Getters and setters
    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
