package com.spoj.online_judge.Models;

import com.spoj.online_judge.User.entity.User;

public class CreateUser {
    private User user;
    private String[] userRoles = {"USER"};

    public CreateUser() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String[] getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(String[] userRoles) {
        this.userRoles = userRoles;
    }
}
