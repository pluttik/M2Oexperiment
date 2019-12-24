package com.example.demo.data.entity;
// child class in a bidirectional many-to-one relationship with use of @JoinColumn
// parent: University

import javax.persistence.*;

@Entity
public class Student extends LowerClass {

    @ManyToOne
    @JoinColumn(name = "ucid")
    private University university;

    public Student() {
        super();
    }

    public Student(String studentName, University university) {
        super(studentName);
        this.university = university;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }
}
