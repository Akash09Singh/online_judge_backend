package com.spoj.online_judge.Roles.Repository;

import com.spoj.online_judge.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Role, Integer> {
    Role findByRole(String roleName);
}
