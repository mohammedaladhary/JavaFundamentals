package com.example.spring_data_jpa.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tbl_section")
@Inheritance(strategy = InheritanceType.JOINED)
public class Section {

    @Id
    private String id;

    private String courseCode;
    private Short roomNum;
    private String instructor;

    public Section() {
    }

    public Section(String id, String courseCode, Short roomNum, String instructor) {
        this.id = id;
        this.courseCode = courseCode;
        this.roomNum = roomNum;
        this.instructor = instructor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public Short getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(Short roomNum) {
        this.roomNum = roomNum;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Section section = (Section) o;
        return Objects.equals(id, section.id) && Objects.equals(courseCode, section.courseCode) && Objects.equals(roomNum, section.roomNum) && Objects.equals(instructor, section.instructor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseCode, roomNum, instructor);
    }

    @Override
    public String toString() {
        return "Section{" +
                "id='" + id + '\'' +
                ", courseCode='" + courseCode + '\'' +
                ", roomNum=" + roomNum +
                ", instructor='" + instructor + '\'' +
                '}';
    }
}