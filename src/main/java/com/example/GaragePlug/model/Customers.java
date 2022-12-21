package com.example.GaragePlug.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Customers {
int custID;
String firstname;
String lastname;
String type;
    @OneToMany(mappedBy = "Customers", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Orders> orders = new HashSet<>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getCustID() {
        return custID;
    }

    public void setCustID(int custID) {
        this.custID = custID;
    }

    public String getCustFirstname() {
        return firstname;
    }

    public void setCustFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getCustLastname() {
        return lastname;
    }

    public void setCustLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCustType() {
        return type;
    }

    public void setCustType(String type) {
        this.type = type;
    }

    public Customers(String firstname, String lastname, String type) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.type = type;
}
}
