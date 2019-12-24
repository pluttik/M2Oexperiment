package com.example.demo.data.entity;
// parent class in a bidirectional many-to-one relationship without use of @JoinColumn
// child: Transaction

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Account extends UpperClass {

    @OneToMany(mappedBy = "account")
    private List<Transaction> transactions;

    public Account() {
        super();
    }

    public Account(String accountName) {
        super(accountName);
        this.transactions = new ArrayList<>();
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
