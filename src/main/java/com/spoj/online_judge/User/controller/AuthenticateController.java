package com.spoj.online_judge.User.controller;

import com.spoj.online_judge.User.entity.JwtRequest;
import com.spoj.online_judge.User.entity.JwtResponse;
import com.spoj.online_judge.User.entity.User;
import com.spoj.online_judge.User.service.UserDetailsServiceImpl;
import com.spoj.online_judge.User.service.UserService;
import com.spoj.online_judge.exception.customExceptiom.UserNotFoundException;
import com.spoj.online_judge.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class AuthenticateController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserService userService;


    @PostMapping("/generate-token")
    public ResponseEntity<JwtResponse> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        System.out.println("generate-token end point is being called");
        try{
            System.out.println(jwtRequest.getUsername());
            System.out.println(jwtRequest.getPassword());
            authenticate(jwtRequest.getUsername(),jwtRequest.getPassword());
            System.out.println("authentication successful");

        }catch (UserNotFoundException e){
            e.printStackTrace();
            throw new UserNotFoundException("user not found ");
        }

        UserDetails userDetails = this.userDetailsServiceImpl.loadUserByUsername(jwtRequest.getUsername());
        String token = this.jwtUtil.generateToken(userDetails);
        System.out.println(token+"hey");
        User user = userService.findByUserName(jwtRequest.getUsername());
        if(user==null) throw new UserNotFoundException("user not found with user name: "+ jwtRequest.getUsername());

        return new ResponseEntity<>(new JwtResponse(token), HttpStatus.OK);
    }

    private void authenticate(String username, String password) throws Exception {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }catch (DisabledException e){
            throw new Exception("user disabled : "+e.getMessage());
        }catch (BadCredentialsException e){
            throw new Exception("bad user credentials : "+e.getMessage());
        }

    }
}
