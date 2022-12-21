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
                .mvcMatchers("/loginhome").authenticated()
                .anyRequest().permitAll();

        http.formLogin()
                .loginPage("/login")
                /*.successHandler((request, response, authentication) -> {
                    response.sendRedirect("/loginhome");
                })*/
                .defaultSuccessUrl("/loginhome");
        return http.build();
    }
}
