package com.spring_sandbox.spring_sandbox.util.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// Here, we configure Spring Security to only accept
// HTTPS requests and block non-secure HTTP channels.
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .authorizeRequests()
                    .antMatchers(HttpMethod.GET).authenticated()
                    .and()
                .httpBasic();
        http
            .csrf()
            .disable();
    }
}
