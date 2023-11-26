package com.koombea.twitterclone.twitterclone.service;

import com.koombea.twitterclone.twitterclone.dto.UserDto;
import com.koombea.twitterclone.twitterclone.models.User;

public interface UserService {
    User findByLogin(String login);
    User save(UserDto user);
}
