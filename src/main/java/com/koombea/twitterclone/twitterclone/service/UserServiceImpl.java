package com.koombea.twitterclone.twitterclone.service;

import com.koombea.twitterclone.twitterclone.dto.UserDto;
import com.koombea.twitterclone.twitterclone.models.User;
import com.koombea.twitterclone.twitterclone.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepo;

    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User findByLogin(String login) {
        return userRepo.findByLogin(login);
    }

    @Override
    public User save(UserDto userDto) {
        User user = new User(userDto.getUsername(),
                userDto.getEmail(), userDto.getFullName(), userDto.getPassword());
        return userRepo.save(user);
    }
}
