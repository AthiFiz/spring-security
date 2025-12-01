package com.athifiz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception{
//        http.authorizeHttpRequests((request) -> request.anyRequest().authenticated());
//        http.authorizeHttpRequests((request) -> request.anyRequest().permitAll());
//        http.authorizeHttpRequests((request) -> request.anyRequest().denyAll());
        http.authorizeHttpRequests((requests) -> requests
                .requestMatchers("/account", "/balance", "/loans", "/cards").authenticated()
                .requestMatchers("/notices", "/contact", "/error").permitAll());
        http.formLogin(withDefaults());
//        http.formLogin(formLoginConfigurer -> formLoginConfigurer.disable());
        http.httpBasic(withDefaults());
//        http.httpBasic(httpBasicConfigurer -> httpBasicConfigurer.disable());
        return http.build();
    }

}
