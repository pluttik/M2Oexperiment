package com.example.demo.data.entity;
// child class in a unidirectional many-to-one relationship with one child object on the many-side
// parent: Team

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Member extends LowerClass {

    @ManyToOne
    private Team team;

    public Member() {
        super();
    }

    public Member(String memberName, Team team) {
        super(memberName);
        this.team = team;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
