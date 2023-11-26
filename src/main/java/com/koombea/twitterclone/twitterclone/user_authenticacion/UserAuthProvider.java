package com.koombea.twitterclone.twitterclone.user_authenticacion;

import com.koombea.twitterclone.twitterclone.models.User;
import com.koombea.twitterclone.twitterclone.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class UserAuthProvider implements AuthenticationProvider {

    private UserRepository userRepo;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String login = authentication.getName();
        String password = authentication.getCredentials().toString();

        // Check if login is email or email
        User user = userRepo.findByLogin(login);

        // Verify password
        return new UsernamePasswordAuthenticationToken(login, password);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
