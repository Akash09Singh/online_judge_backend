package com.spoj.online_judge.security;


import com.spoj.online_judge.User.service.UserDetailsServiceImpl;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private JwtAuthenticationEntryPoint authenticationEntryPoint;

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        final String requestTokenHeader = request.getHeader("Authorization");
        System.out.println("jwt authentication fliter is being called");

        String username = null;
        String jwtToken = null;
        if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer")){
            jwtToken = requestTokenHeader.substring(7);
            try {
                username = this.jwtUtil.extractUsername(jwtToken);
            }catch (ExpiredJwtException e){
                e.printStackTrace();
                System.out.println("jwt token expired");

            }catch (Exception e){
                e.printStackTrace();
                System.out.println("error");
            }

        }else {
            System.out.println("invalid or token doesn't start with Bearer");
        }
        //validate
        if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null){
            final UserDetails userDetails = this.userDetailsServiceImpl.loadUserByUsername(username);
            if (this.jwtUtil.validateToken(jwtToken, userDetails)){
                //token is valid
                UsernamePasswordAuthenticationToken usernamePasswordAuthentication = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                usernamePasswordAuthentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthentication);
            }else {
                System.out.println("invalid token");
            }
//            filterChain.doFilter(request,response);
        }

        filterChain.doFilter(request, response);

    }
}
