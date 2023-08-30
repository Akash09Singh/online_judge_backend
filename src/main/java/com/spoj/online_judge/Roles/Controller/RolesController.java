package com.spoj.online_judge.Roles.Controller;

import com.spoj.online_judge.Roles.Service.RolesService;
import com.spoj.online_judge.entity.Role;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/role")
public class RolesController {
    RolesService rolesService;

    public RolesController(RolesService rolesService) {
        this.rolesService = rolesService;
    }
    @GetMapping("")
    public ResponseEntity<List<Role>>getAllRoles(){
        Role role = rolesService.getRoleByRoleName("ADMIN");
        List<Role> allRole = rolesService.findAllRole();
        return new ResponseEntity<>(allRole, HttpStatus.OK );
    }
    @PostMapping("")
    public ResponseEntity<Role>createRoles(@RequestBody Role role){
        Role createdRole = rolesService.createRole(role);
        return new ResponseEntity<>(createdRole, HttpStatus.CREATED );
    }

}
