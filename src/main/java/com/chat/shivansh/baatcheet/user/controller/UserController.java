package com.chat.shivansh.baatcheet.user.controller;

import com.chat.shivansh.baatcheet.user.dto.UserResponse;
import com.chat.shivansh.baatcheet.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    public UserResponse me(Principal principal) {
        return userService.getCurrentUser(principal.getName());
    }
}
