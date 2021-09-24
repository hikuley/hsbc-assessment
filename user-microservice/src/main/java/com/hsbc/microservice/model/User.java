package com.hsbc.microservice.model;

import javax.persistence.Entity;

@Entity(name = "users")
public class User extends BaseEntity {

    private String firstName;
    private String lastName;
    private String title;
    private String dob;
    private String jobTitle;

    public User() {
    }

    public User(final String firstName, final String lastName) {
        this.firstName = firstName;
        this.lastName  = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String surname) {
        this.lastName = surname;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(final String dob) {
        this.dob = dob;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(final String jobTitle) {
        this.jobTitle = jobTitle;
    }
}
