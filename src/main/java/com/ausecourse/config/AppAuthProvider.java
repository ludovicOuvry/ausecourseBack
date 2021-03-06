package com.ausecourse.config;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

import com.ausecourse.dao.UserSecurityDao;


import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

public class AppAuthProvider extends DaoAuthenticationProvider {
    @Autowired
    UserSecurityDao userDetailsService;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) authentication;
        String name = auth.getName();
        String password = auth.getCredentials()
                .toString();
        
        System.out.println("hellll " + password);
        UserDetails user = userDetailsService.loadUserByUsername(name);
        if (user == null || !user.getPassword().equals(password)) {
        	System.out.println("omggg bad credential " + password);;
            throw new BadCredentialsException("Username/Password does not match for " + auth.getPrincipal());
        }
        return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
    }
    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}