package com.jhs.loginwithnofront.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeHttpRequests()
                .mvcMatchers("/", "/signUp", "/loginPage").permitAll()
                .anyRequest().authenticated();

        http.formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/loginhome");
        return http.build();
    }
}
