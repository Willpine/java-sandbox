package com.spring_sandbox.spring_sandbox.util.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// Here, we configure Spring Security to only accept
// HTTPS requests and block non-secure HTTP channels.
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .requiresChannel()
        .anyRequest()
        .requiresSecure();
        http
        .csrf()
        .disable();
    }
}
