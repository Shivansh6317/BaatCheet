package com.chat.shivansh.baatcheet.user.service;

import com.chat.shivansh.baatcheet.user.dto.UserResponse;
import com.chat.shivansh.baatcheet.user.entity.User;
import com.chat.shivansh.baatcheet.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse getCurrentUser(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        UserResponse response = new UserResponse();
        response.setUsername(user.getUsername());
        return response;
    }
}
