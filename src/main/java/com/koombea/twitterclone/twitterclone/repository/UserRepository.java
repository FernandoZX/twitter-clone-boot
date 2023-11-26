package com.koombea.twitterclone.twitterclone.repository;

import com.koombea.twitterclone.twitterclone.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    Iterable<User> findAllByUsername(String username);
    boolean existsByUsername(String username);

    @Query("select u from User u where u.username = :login or u.email = :login")
    public User findByLogin(@Param("login") String login);
}
