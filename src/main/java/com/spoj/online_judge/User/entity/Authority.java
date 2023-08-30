package com.spoj.online_judge.User.entity;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority {
    private String authority;

    public Authority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }
}
