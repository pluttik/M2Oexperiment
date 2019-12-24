package com.example.demo.data.entity;
// child class in a unidirectional many-to-one relationship with List of children on the one-side
// parent: Boss

import javax.persistence.Entity;

@Entity
public class Company extends LowerClass {

    public Company() {
        super();
    }

    public Company(String name) {
        super(name);
    }
}
