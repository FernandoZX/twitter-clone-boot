package com.koombea.twitterclone.twitterclone.security;

import com.koombea.twitterclone.twitterclone.user_authenticacion.UserAuthFilter;
import com.koombea.twitterclone.twitterclone.user_authenticacion.UserAuthProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
@Configuration
@RequiredArgsConstructor
public class SpringSecurityConfiguration {

    private static final String[] AUTH_WHITELIST = {
            "/swagger-resources/**",
            "/swagger-ui/**",
            "/swagger-ui.html",
            "/v3/api-docs/**",
            "/h2-console/**",
            "/webjars/**",
            "/favicon.ico",
            "/static/**",
            "/signup/**",
            "/error/**",
            "/public/**",
            "/article/read/**",
            "/download/file/**",
            "/" //landing page is allowed for all
    };

    @Bean
    public AuthenticationProvider customAuthProvider() {
        return new UserAuthProvider();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorize -> authorize.requestMatchers("/sign-up").permitAll().anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .addFilterAt(new UserAuthFilter("/login"), SecurityFilterChain.AUTHORIZATION_FILTER_POSITION)
                .formLogin(formLogin -> formLogin.loginPage("/login").permitAll())
                .logout(logout -> logout.deleteCookies("JSESSIONID").permitAll());

        return http.build();
    }
}
