package com.scanbuyTest.Scanbuydemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "UserDetails")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    public User() {
    }

    User(String firstName, String lastName, String password, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getlastName() {
        return this.lastName;
    }

    public String getpassword() {
        return this.password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setfirstName(String firstName) {
        this.firstName = firstName;

    }

    public void setlastName(String lastName) {
        this.lastName = lastName;

    }

    public void setpassword(String password) {
        this.password = password;
    }

    public void setemail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User[firstName=" + firstName + ",lastName=" + lastName + ",email=" + email + ",]";

    }
}
