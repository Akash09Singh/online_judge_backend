package com.spoj.online_judge.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.spoj.online_judge.Roles.RolesServiceImpl.RolesServiceImpl;
import com.spoj.online_judge.Roles.Service.RolesService;
import com.spoj.online_judge.User.entity.Authority;
import com.spoj.online_judge.User.entity.User;
import com.spoj.online_judge.User.service.UserService;
import com.spoj.online_judge.UserRole.Service.UserRolesService;
import com.spoj.online_judge.entity.Role;
import com.spoj.online_judge.entity.UserRole;
import com.spoj.online_judge.exception.customExceptiom.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;

import java.util.*;

public class Login {
    @Autowired
    @JsonIgnore
    UserService userService;

    @Autowired
    @JsonIgnore
    UserRolesService userRolesService;

    @Autowired
    @JsonIgnore
    RolesServiceImpl rolesServiceImpl;

    @JsonProperty
    private int id;
    @JsonProperty
    private String  username;
    @JsonProperty
    private String email;
    @JsonProperty
    private String firstName;
    @JsonProperty
    private String lastName;
    @JsonProperty
    private String phone;
    @JsonProperty
    private List<String> authorities;


    public Login(int id, String username, String email, String firstName, String lastName, String phone,UserService userService, UserRolesService userRolesService, RolesServiceImpl rolesServiceImpl) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.userService = userService;
        this.userRolesService = userRolesService;
        this.rolesServiceImpl = rolesServiceImpl;
    }

    public Login() {
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


    public List<String> getAuthorities() {
        System.out.println("get authority for login model is called");
        System.out.println(userService);
        User user = userService.findByUserName(username);
        if (user==null){
            throw new UserNotFoundException("user doesn't exists with username: "+username);
        }
        int userId = user.getId();
        //getting all the roles id associated with user
        List<UserRole> userRoles = userRolesService.findUserRolesByUserId(userId);
        //store all the role id associated with user
        List<Integer> userRolesId = new ArrayList<>();
        for (UserRole ur:userRoles){
            userRolesId.add(ur.getRoleId());
        }
        // getting all the roles name associated with those role id

        List<String> authoritySet = new ArrayList<>();
        for (int roleId:userRolesId){
            Role role = rolesServiceImpl.getRoleById(roleId);
            authoritySet.add(role.getRole());
        }

        this.setAuthorities(authoritySet);



        return authoritySet;
    }

    public void setAuthorities(List<String> authorities) {
        this.authorities = authorities;
    }
}
