package com.example.demo.data.entity;
// parent class in a bidirectional many-to-one relationship with use of @JoinColumn
// child: Student

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class University extends UpperClass {

    @OneToMany(mappedBy = "university", cascade = CascadeType.ALL)
    private List<Student> students;

    public University() {
        super();
    }

    public University(String universityName) {
        super(universityName);
        this.students = new ArrayList<>();
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
