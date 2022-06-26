package com.kotlinken.springbootjwt.config;

import com.kotlinken.springbootjwt.filter.JwtAuthenticationFilter;
import com.kotlinken.springbootjwt.filter.JwtProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {


    private final JwtProperties jwtProperties;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.addFilter(new JwtAuthenticationFilter(jwtProperties, authenticationManager()));

        return http.build();
    }

    @Bean
    AuthenticationManager authenticationManager(){
        return authenticationManager();
    }

}
