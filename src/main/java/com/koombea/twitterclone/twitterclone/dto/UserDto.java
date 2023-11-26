package com.koombea.twitterclone.twitterclone.dto;
import com.koombea.twitterclone.twitterclone.models.Tweet;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class UserDto {
    private String username;
    private String email;
    private String fullName;
    private String password;
    private String passwordConfirmation;

    public UserDto(String username, String email, String fullName, String password) {
        this.username = username;
        this.email = email;
        this.fullName = fullName;
        this.password = password;
    }

    public UserDto() {

    }


}
