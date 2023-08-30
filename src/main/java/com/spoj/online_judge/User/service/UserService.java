package com.spoj.online_judge.User.service;

import com.spoj.online_judge.Roles.Repository.RolesRepository;
import com.spoj.online_judge.User.entity.User;
import com.spoj.online_judge.User.repository.UserRepository;
import com.spoj.online_judge.UserRole.Repository.UserRoleRepository;
import com.spoj.online_judge.entity.Role;
import com.spoj.online_judge.entity.UserRole;
import com.spoj.online_judge.exception.customExceptiom.UserNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    private UserRepository userRepository;
    @Autowired
    private RolesRepository rolesRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
    public UserService(UserRepository userRepository, RolesRepository rolesRepository, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.rolesRepository=rolesRepository;
        this.userRoleRepository = userRoleRepository;
    }


    public User registerUser(User user, String[] userRoles) throws Exception {
        User local = userRepository.findByUsername(user.getUsername());

        if (local!= null){
            System.out.println("username already exist");
            throw new Exception("username already exist");
        }else{
            User createdUser = userRepository.save(user);
            for (String role:userRoles){
                Role roleLocal = rolesRepository.findByRole(role);
                System.out.println(roleLocal);
                if (roleLocal==null){
                    System.out.println("role defined for user does not exist role: "+ role );
                    throw new Exception("role defined for user already exist: "+ role);
                }else{
                    UserRole newUserRole = new UserRole(user.getId(),roleLocal.getId());
                    userRoleRepository.save(newUserRole);
                }
            }
            return createdUser;

        }


    }

    public User logIn(String username, String password) throws UserNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user==null || !password.equals(user.getPassword())){
            throw new UserNotFoundException("invalid username or password");
        }
        return user;
    }




    public List<User> findAll(){
        List<User> allUser = userRepository.findAll();
        return allUser;
    }

    //find user by username
    public User findByUserName(String userName){
        return userRepository.findByUsername(userName);
    }

    //delete user by userId
    @Transactional
    public String deleteByUserId(int userId) throws UserNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(()->new UserNotFoundException("no user exist with id: "+userId));
        userRoleRepository.deleteByUserId(userId);
        userRepository.deleteById(userId);
        return user.getUsername();
    }






}
