package com.spring_sandbox.spring_sandbox.dto.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.spring_sandbox.spring_sandbox.domain.User;
import com.spring_sandbox.spring_sandbox.util.exception.NoContentException;

import org.springframework.data.domain.Page;

import lombok.Getter;

@Getter
public class UserPageModel {
    private String name;
    private LocalDateTime registerDate;

    public static PageModel<User, UserPageModel> ofPage(Page<User> users){
        PageModel<User, UserPageModel> model = new PageModel<>();
        model.setConteudo(users);
        model.setConteudoList(ofList(users.getContent()));
        return model;
    }

    public static List<UserPageModel> ofList(List<User> users) {
        if(users.isEmpty()) throw new NoContentException("Não há usuários");
        return users.stream()
                    .map(user -> of(user))
                    .collect(Collectors.toList());
    }

    private static UserPageModel of (User user) {
        UserPageModel model = new UserPageModel();
        model.name = user.getName();
        model.registerDate = user.getRegisterDate();
        return model;
    }

    protected UserPageModel(){}
}
