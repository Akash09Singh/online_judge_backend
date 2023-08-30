package com.spoj.online_judge.User.service;

import com.spoj.online_judge.Roles.Service.RolesService;
import com.spoj.online_judge.User.entity.CustomUserDetails;
import com.spoj.online_judge.User.entity.User;
import com.spoj.online_judge.User.repository.UserRepository;
import com.spoj.online_judge.UserRole.Service.UserRolesService;
import com.spoj.online_judge.exception.customExceptiom.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Autowired
    private RolesService rolesService;

    @Autowired
    private UserRolesService userRolesService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UserNotFoundException {
        System.out.println("load user by username is being called");
        System.out.println(userService);
        User user =  this.userService.findByUserName(username);
        if (user==null) throw new UserNotFoundException("username doesn't exist");
        CustomUserDetails userDetails = new CustomUserDetails(user.getUsername(), user.getPassword(), user.isEnable());

        userDetails.setUserService(userService);
        userDetails.setUserRolesService(userRolesService);
        userDetails.setRolesService(rolesService);
        System.out.println("load user by user name method executed successfully");
        System.out.println(user.toString());
        return userDetails;

    }
}
