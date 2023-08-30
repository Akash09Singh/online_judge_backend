package com.spoj.online_judge.User.entity;

import com.spoj.online_judge.Roles.Service.RolesService;
import com.spoj.online_judge.User.service.UserService;
import com.spoj.online_judge.UserRole.Repository.UserRoleRepository;
import com.spoj.online_judge.UserRole.Service.UserRolesService;
import com.spoj.online_judge.entity.Role;
import com.spoj.online_judge.entity.UserRole;
import com.spoj.online_judge.exception.customExceptiom.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.*;
@Component
public class CustomUserDetails implements UserDetails {

    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;
    private boolean enabled ;
    @Autowired
    private UserRolesService userRolesService;

    @Autowired
    private UserService userService;

    @Autowired
    private RolesService rolesService;


    public CustomUserDetails() {
    }

    public CustomUserDetails(String username, String password, boolean enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;

    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        System.out.println("get authority from custom user detail is called");
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

        Set<Authority> authoritySet = new HashSet<>();
        for (int roleId:userRolesId){
            Role role = rolesService.getRoleById(roleId);
            authoritySet.add(new Authority(role.getRole()));
        }



        return authoritySet;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRolesService getUserRolesService() {
        return userRolesService;
    }

    public void setUserRolesService(UserRolesService userRolesService) {
        this.userRolesService = userRolesService;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public RolesService getRolesService() {
        return rolesService;
    }

    public void setRolesService(RolesService rolesService) {
        this.rolesService = rolesService;
    }
}
