package com.spring_sandbox.spring_sandbox.util.config;

import com.spring_sandbox.spring_sandbox.service.SandboxUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// Here, we configure Spring Security to only accept
// HTTPS requests and block non-secure HTTP channels.
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SandboxUserService userDetailsService;
    
    // Aqui definimos onde o usuário vai precisar ou não de identificação
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .csrf().disable()
        .authorizeRequests()
                    .antMatchers("/h2-console/*").permitAll()
                    .antMatchers("/user/pine").hasRole("ADMIN")
                    .antMatchers(HttpMethod.POST,"/user").hasRole("ADMIN")
                    .anyRequest().authenticated()
                    .and()
                    .headers().frameOptions().disable()
                    .and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth
            .userDetailsService(userDetailsService)
            .passwordEncoder(new BCryptPasswordEncoder());
    }

    // In-memory authentication
    // @Override
    // protected void configure(AuthenticationManagerBuilder auth) throws Exception{
    //     auth.inMemoryAuthentication()
    //     .withUser("willpine").password(passwordEncoder().encode("willpine")).roles("ADMIN");
    // }

    // Para o spring security não bloquear as páginas estáticas do browser.
    @Override
    public void configure(WebSecurity web) throws Exception{
        web.ignoring().antMatchers("/materialize/**","/style/**");
    }
}