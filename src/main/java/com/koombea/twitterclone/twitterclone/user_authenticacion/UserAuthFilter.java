package com.koombea.twitterclone.twitterclone.user_authenticacion;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import java.io.IOException;

public class UserAuthFilter extends AbstractAuthenticationProcessingFilter {

    private UserAuthProvider authManager;
    public UserAuthFilter(String defaultFilterProcessesUrl) {
        super(defaultFilterProcessesUrl);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        UsernamePasswordAuthenticationToken auth =
                new UsernamePasswordAuthenticationToken(login, password);

        return authManager.authenticate(auth);
    }
}
