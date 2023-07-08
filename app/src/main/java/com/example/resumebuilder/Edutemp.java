package com.example.resumebuilder;

public class Edutemp {
    String course,grade,school,year;

    public Edutemp() {
    }

    public Edutemp(String course, String grade, String school, String year) {
        this.course = course;
        this.grade = grade;
        this.school = school;
        this.year = year;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
