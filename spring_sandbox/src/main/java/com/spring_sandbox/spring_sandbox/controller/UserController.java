package com.spring_sandbox.spring_sandbox.controller;

import com.spring_sandbox.spring_sandbox.domain.User;
import com.spring_sandbox.spring_sandbox.dto.command.CreateUserCommand;
import com.spring_sandbox.spring_sandbox.dto.model.PageModel;
import com.spring_sandbox.spring_sandbox.dto.model.UserModel;
import com.spring_sandbox.spring_sandbox.dto.model.UserPageModel;
import com.spring_sandbox.spring_sandbox.service.SandboxUserService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@AllArgsConstructor
@RestController
@RequestMapping("user")
public class UserController {
    
    // O autowired é usado para para Dependency injection;
    // Precisamos de dependency injection pois caso instanciassemos
    // um objeto usando um constructor, caso este constructor mude,
    // vamos precisar mudar sua declaração aqui.
    // É recomendado fazer isso com um construror ao invés
    // de usar apenas o um campo:

    private final SandboxUserService userService;
    
    // public UserController(SandboxUserService userService) {
    //     this.userService = userService;
    // } // O all args constructor cuida de criar isso
    
    @PostMapping
    public ResponseEntity<User> add(@RequestBody CreateUserCommand command){
        log.info("GET ADD REQUEST CALLED CHANGED");
        return ResponseEntity.ok(userService.add(command));
    }

    @GetMapping("{id}")
    public ResponseEntity<UserModel> retrieve(@PathVariable(name = "id") Long id){
        User user = userService.retrieve(id);
        UserModel model = UserModel.of(user);
        log.info("GET RETRIEVE ONE REQUEST CALLED");
        return ResponseEntity.ok(model);
    }

    @GetMapping
    public ResponseEntity<PageModel<User, UserPageModel>> retrievePage(Pageable pageable) {
        Page<User> users = userService.retrievePage(pageable);
        PageModel<User, UserPageModel> model = UserPageModel.ofPage(users);
        log.info("GET RETRIEVE ALL REQUEST CALLED");
        return ResponseEntity.ok(model);
    }
}
