package com.chat.shivansh.baatcheet.auth.service;
import com.chat.shivansh.baatcheet.auth.dto.LoginRequest;
import com.chat.shivansh.baatcheet.auth.dto.RegisterRequest;
import com.chat.shivansh.baatcheet.user.entity.User;
import com.chat.shivansh.baatcheet.user.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void register(RegisterRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(encoder.encode(request.getPassword()));
        userRepository.save(user);
    }

    public String login(LoginRequest request) {
        User user = userRepository
                .findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!encoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return user.getUsername();
    }
}

