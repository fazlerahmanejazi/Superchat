package com.superchat.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Contact")
public class Contact {

    @Id @GeneratedValue private long userId;
    private String name;
    private String email;

    public Contact() {

    }

    public Contact(long userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
    }

    public Contact(Contact contact) {
        this.userId = contact.getUserId();
        this.name = contact.getName();
        this.email = contact.getEmail();
    }

    public long getUserId() {
        return this.userId;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }


}
