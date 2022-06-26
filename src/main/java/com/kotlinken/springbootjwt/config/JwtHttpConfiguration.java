package com.kotlinken.springbootjwt.config;

import com.kotlinken.springbootjwt.filter.JwtAuthenticationFilter;
import com.kotlinken.springbootjwt.filter.JwtProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JwtHttpConfiguration extends AbstractHttpConfigurer<JwtHttpConfiguration, HttpSecurity> {

    private final JwtProperties jwtProperties;

    @Override
    public void configure(HttpSecurity http) {
        final AuthenticationManager authenticationManager = http.getSharedObject(AuthenticationManager.class);
        http.antMatcher("/graphql").addFilter(new JwtAuthenticationFilter(authenticationManager, jwtProperties));
    }
}
