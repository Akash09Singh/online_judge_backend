package com.spoj.online_judge.User.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "user")
@Component
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;
    @Column(name = "username", nullable = false, unique = true)
    @JsonProperty
    private String username;

    @Column(name = "email")
    @JsonProperty
    private String email;

    @Column(name= "first_name")
    @JsonProperty
    private String firstName;

    @Column(name = "last_name")
    @JsonProperty
    private String lastName;
    @Column(name = "phone")
    @JsonProperty
    private String phone;
    @Column(name = "enable")
//    @JsonIgnore
    private boolean enable = true;
    @Column(name = "password", nullable = false)
    @JsonProperty
    private String password;

    public User(String username, String email, String firstName, String lastName, String phone, boolean enable, String password) {
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.enable = enable;
        this.password = password;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", enable=" + enable +
                ", password='" + password + '\'' +
                '}';
    }
}
