package com.chat.shivansh.baatcheet.user.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "baat_cheet_users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;
}

