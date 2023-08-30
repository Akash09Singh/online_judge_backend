package com.spoj.online_judge.UserRole.Service;

import com.spoj.online_judge.entity.UserRole;

import java.util.List;

public interface UserRolesService {
    List<UserRole> findUserRolesByUserId(int userId);
}
