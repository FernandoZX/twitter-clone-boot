package com.koombea.twitterclone.twitterclone.repository;

import com.koombea.twitterclone.twitterclone.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Iterable<User> findAllByUserName(String userName);
    boolean existsByUserName(String username);
}
