package com.example.secureApp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()) // CSRF protection
            .and()
            .authorizeRequests()
                .antMatchers("/login", "/logout").permitAll() // Allow login/logout without authentication
                .anyRequest().authenticated() // Secure all other URLs
            .and()
            .formLogin()
                .loginPage("/login") // Custom login page
                .permitAll()
            .and()
            .logout()
                .permitAll();

        return http.build();
    }
}
