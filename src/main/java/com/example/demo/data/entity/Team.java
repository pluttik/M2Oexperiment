package com.example.demo.data.entity;
// parent class in a unidirectional many-to-one relationship with one child object on the omany-side
// child: Member

import javax.persistence.Entity;

@Entity
public class Team extends UpperClass {

    public Team() {
        super();
    }

    public Team(String teamName) {
        super(teamName);
    }
}
