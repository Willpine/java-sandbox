package com.spring_sandbox.spring_sandbox.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.spring_sandbox.spring_sandbox.dto.command.CreateUserCommand;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.Getter;

@Entity@Table(name = "USER")@Getter
public class User implements DomainEntity, UserDetails{

    @Id
    @Column(name = "USER_NAME")
    private String name;
    @Column(name = "USER_NICKNAME")
    private String nickname;
    @Column(name = "USER_PASSWORD")
    private String password;
    @Column(name = "USER_REGISTRATION_DATE")
    private LocalDateTime registerDate;

    @ManyToMany
    @JoinTable(
        name="USER_ROLES"
        ,joinColumns = @JoinColumn(name="USER_NAME")
        ,inverseJoinColumns = @JoinColumn(name="ROLE_ID")
    )
    private List<Role> roles = new ArrayList<>();

    protected User() {}

    public static User addUser(CreateUserCommand command) {
        command.validate();
        return new User(command);
    }

    private User (CreateUserCommand command){
        this.name = command.getName();
        this.nickname = command.getNickname();
        this.password = encryptPassword(command.getPassword());
        this.registerDate = LocalDateTime.now();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles;
    }

    @Override
    public String getUsername() {
        return this.name;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    private String encryptPassword(String password){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }

}
