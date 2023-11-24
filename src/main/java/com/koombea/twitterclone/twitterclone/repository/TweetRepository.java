package com.koombea.twitterclone.twitterclone.repository;

import com.koombea.twitterclone.twitterclone.models.Tweet;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TweetRepository extends CrudRepository<Tweet,Long> {
    Iterable<Tweet> findAllByUserId(Long userId);
}
