package com.chat.shivansh.baatcheet.user.repository;

import com.chat.shivansh.baatcheet.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
}

