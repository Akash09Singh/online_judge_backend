package com.spoj.online_judge.Roles.Service;

import com.spoj.online_judge.entity.Role;

import java.util.List;
import java.util.Optional;

public interface RolesService {
    Role createRole(Role role);
    Role getRoleById(int theId);

    Role getRoleByRoleName(String roleName);

    List<Role> findAllRole();
}
