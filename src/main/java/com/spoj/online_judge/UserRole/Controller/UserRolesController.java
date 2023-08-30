package com.spoj.online_judge.UserRole.Controller;

import com.spoj.online_judge.Roles.Repository.RolesRepository;
import com.spoj.online_judge.UserRole.Repository.UserRoleRepository;
import com.spoj.online_judge.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user-roles")
public class UserRolesController {
    @Autowired
    private UserRoleRepository userRoleRepository;

    @GetMapping("/{userId}")
    public ResponseEntity<List<UserRole>> findUserRoleByUserId(@PathVariable int userId){
        List<UserRole> userRoles = userRoleRepository.findByUserId(userId);
        return new ResponseEntity<>(userRoles, HttpStatus.OK);
    }
}
