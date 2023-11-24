package com.koombea.twitterclone.twitterclone.models;

import com.koombea.twitterclone.twitterclone.validations.PasswordMatches;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@PasswordMatches
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotEmpty
    @Size(min=4)
    @Column(name = "username", unique=true, nullable = false)
    private String username;


    @Email
    @NotEmpty
    @Column(name = "email", unique=true, nullable = false)
    private String email;

    @NotEmpty
    @Column(name = "fullName", unique=true, nullable = false)
    private String fullName;

    @NotEmpty
    @Column(nullable = false)
    @Size(min = 8)
    private String password;

    @Transient
    private String passwordConfirmation;

    @CreationTimestamp
    @Column(name = "createdAt", nullable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updatedAt", nullable = false)
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Tweet> tweets;

}