package com.spring_sandbox.spring_sandbox.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.security.core.GrantedAuthority;

import lombok.Getter;

// Classe que configura os níveis de autorização de
// cada usuário na aplicação.

@Entity @Getter
public class Role implements GrantedAuthority{

    @Id
    @Column(name = "ROLE_ID")
    private String roleName;

    // Um equivalente deve ser criado em Users
    @ManyToMany(mappedBy = "roles") // Vários usuários podem ter várias autoridades
    @JsonIgnore
    private List<User> users;

    @Override
    public String getAuthority() {
        return this.roleName;
    }

}