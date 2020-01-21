package com.example.demo.data.entity;
// parent class in a unidirectional many-to-one relationship with List of children on the one-side
// child: Company

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Boss extends UpperClass {

    @OneToMany(cascade = CascadeType.ALL)
    private List<Company> companies;

    public Boss() {
        super();
    }

    public Boss(String bossName) {
        super(bossName);
        this.companies = new ArrayList<>();
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }
}
