package com.company.model;

public class StudentScore {
    private Integer studentId;
    private Integer courseId;
    private Integer score;

    public StudentScore(Integer studentId, Integer courseId, Integer score) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.score = score;
    }

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
