package com.SellBuyCar.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Securityconfig {
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {http
            .authorizeHttpRequests().antMatchers("/**").permitAll();
        return http.build();
    }




}
