package com.example.demo.data.entity;
// abstract class to define parent class

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class UpperClass {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ucid;

    @Column(unique = true)
    private String name;

    public UpperClass() {
        super();
    }

    public UpperClass(String name) {
        super();
        this.name = name;
    }

    public int getId() {
        return ucid;
    }

    public void setId(int ucid) {
        this.ucid = ucid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
