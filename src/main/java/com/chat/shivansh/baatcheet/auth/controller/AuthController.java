package com.chat.shivansh.baatcheet.auth.controller;

import com.chat.shivansh.baatcheet.auth.dto.LoginRequest;
import com.chat.shivansh.baatcheet.auth.dto.RegisterRequest;
import com.chat.shivansh.baatcheet.auth.service.AuthService;
import com.chat.shivansh.baatcheet.security.JwtUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;
    private final JwtUtil jwtUtil;

    public AuthController(AuthService authService, JwtUtil jwtUtil) {
        this.authService = authService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        authService.register(request);
        return "User registered successfully";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        String username = authService.login(request);
        return jwtUtil.generateToken(username);
    }
}
