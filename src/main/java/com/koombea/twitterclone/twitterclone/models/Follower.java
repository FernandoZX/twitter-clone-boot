package com.koombea.twitterclone.twitterclone.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "follower", uniqueConstraints = @UniqueConstraint(columnNames={"followed_id", "follower_id"}))
public class Follower {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "followed_id")
    private User followed;

    @ManyToOne
    @JoinColumn(name = "follower_id")
    private User follower;

    @CreationTimestamp
    @Column(name = "createdAt", nullable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updatedAt", nullable = false)
    private LocalDateTime updatedAt;



}