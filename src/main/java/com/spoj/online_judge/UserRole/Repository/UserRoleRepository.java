package com.spoj.online_judge.UserRole.Repository;

import com.spoj.online_judge.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
    void deleteByUserId(int userId);

    List<UserRole> findByUserId(int userId);
}
