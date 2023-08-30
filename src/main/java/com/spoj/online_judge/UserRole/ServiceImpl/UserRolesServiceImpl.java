package com.spoj.online_judge.UserRole.ServiceImpl;

import com.spoj.online_judge.UserRole.Repository.UserRoleRepository;
import com.spoj.online_judge.UserRole.Service.UserRolesService;
import com.spoj.online_judge.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserRolesServiceImpl implements UserRolesService {
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Override
    public List<UserRole> findUserRolesByUserId(int userId) {
        return userRoleRepository.findByUserId(userId);
    }
}
