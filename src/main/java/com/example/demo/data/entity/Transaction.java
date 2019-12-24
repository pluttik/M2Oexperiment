package com.example.demo.data.entity;
// child class in a bidirectional many-to-one relationship without use of @JoinColumn
// parent: Account

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Transaction extends LowerClass {

    @ManyToOne
    private Account account;

    public Transaction() {
        super();
    }

    public Transaction(String transactionName, Account account) {
        super(transactionName);
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
