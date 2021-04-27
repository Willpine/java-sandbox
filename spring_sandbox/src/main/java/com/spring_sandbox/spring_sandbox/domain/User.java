package com.spring_sandbox.spring_sandbox.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.spring_sandbox.spring_sandbox.dto.command.CreateUserCommand;

import lombok.Getter;

@Entity@Table(name = "USER")@Getter
public class User implements DomainEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;
    @Column(name = "USER_NAME")
    private String name;
    @Column(name = "USER_PASSWORD")
    private String password;
    @Column(name = "USER_REGISTRATION_DATE")
    private LocalDateTime registerDate;

    protected User() {}

    public static User addUser(CreateUserCommand command) {
        command.validate();
        return new User(command);
    }

    private User (CreateUserCommand command){
        this.name = command.getName();
        this.password = command.getPassword();
        this.registerDate = LocalDateTime.now();
    }
}
