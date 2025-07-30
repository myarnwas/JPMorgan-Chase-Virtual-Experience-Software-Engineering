package com.jpmc.midascore.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private Double balance;

    @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL)
    private List<TransactionRecord> sentTransactions;

    @OneToMany(mappedBy = "recipient", cascade = CascadeType.ALL)
    private List<TransactionRecord> receivedTransactions;

    // Constructors
    public User() {}

    public User(String name, Double balance) {
        this.name = name;
        this.balance = balance;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public List<TransactionRecord> getSentTransactions() {
        return sentTransactions;
    }

    public List<TransactionRecord> getReceivedTransactions() {
        return receivedTransactions;
    }
}
