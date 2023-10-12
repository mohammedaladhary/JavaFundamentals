package com.example.spring_data_jpa.entity;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

//Annotations(@Entity, @Table and @Id)
@Entity //1
@Table(name = "tbl_course") //2
public class Course {
    @Id     //3
    private String courseCode;

    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
    private Set<Section> sections;
    private String courseName;

    public Course() {
    }

    public Course(String courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(int courseCode) {
        this.courseCode = String.valueOf(courseCode);
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(courseCode, course.courseCode) && Objects.equals(courseName, course.courseName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseCode, courseName);
    }
    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseCode +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}
