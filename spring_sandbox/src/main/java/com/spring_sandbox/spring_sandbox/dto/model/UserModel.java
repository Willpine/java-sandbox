package com.spring_sandbox.spring_sandbox.dto.model;

import java.time.LocalDateTime;

import com.spring_sandbox.spring_sandbox.domain.User;

import lombok.Getter;

@Getter
public class UserModel {
    private String name;
    private LocalDateTime registerDate;

    public static UserModel of(User user) {
        UserModel model = new UserModel();
        model.name = user.getName();
        model.registerDate = user.getRegisterDate();
        return model;
    }

    protected UserModel() {}
}