package com.micromata.webengineering.demo.user;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

// The name "User" is a reserved name for postgres. That is, if we do not change the default name, everything will work
// fine locally but not after we deployed the application on heroku.
@Entity(name = "User_")
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String email;
    @JsonIgnore
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
