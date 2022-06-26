package com.kotlinken.springbootjwt.config;

import com.kotlinken.springbootjwt.filter.JwtAuthenticationFilter;
import com.kotlinken.springbootjwt.filter.JwtProperties;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static com.kotlinken.springbootjwt.config.MyCustomDsl.customDsl;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {


    private final Logger logger = LoggerFactory.getLogger(SecurityConfiguration.class);
    
    private final JwtProperties jwtProperties;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        final AuthenticationManager authenticationManager = http.getSharedObject(AuthenticationManager.class);

//            http.apply(new JwtHttpConfiguration(jwtProperties));
        http.addFilter(new JwtAuthenticationFilter(authenticationManager, jwtProperties));

        return http.build();
    }
}
