package com.procuredox.receivers.db.model;

/**
 * @author procuredox on 1/19/17.
 */
public class NotificationPerson {

    private String firstname;
    private String lastname;
    private String email;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("\"%s %s\" <%s>", firstname, lastname, email);
    }
}