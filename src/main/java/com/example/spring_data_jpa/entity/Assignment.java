package com.example.spring_data_jpa.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tbl_assignments")
@Data
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @OneToOne(mappedBy = "assignment")
    private Grade grade;

    private String assignmentTitle;
    private int score;

    public Assignment() {
    }

    public Assignment(Grade grade, String assignmentTitle, int score) {
        this.grade = grade;
        this.assignmentTitle = assignmentTitle;
        this.score = score;
    }

    public int getId() {
        return Id;
    }

//    public void setId(int id) {
//        Id = id;
//    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public String getAssignmentTitle() {
        return assignmentTitle;
    }

    public void setAssignmentTitle(String assignmentTitle) {
        this.assignmentTitle = assignmentTitle;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
