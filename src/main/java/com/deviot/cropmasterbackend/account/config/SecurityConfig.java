package com.deviot.cropmasterbackend.account.config;

import com.deviot.cropmasterbackend.account.jwt.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authProvider;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(csrf->csrf.disable())
                .authorizeHttpRequests(authRequest->
                        authRequest
                                .requestMatchers("/auth/**"
                                ,"/v2/api-docs"
                                ,"/v3/api-docs"
                                ,"v3/api-docs/**"
                                ,"/swagger-resources"
                                ,"/configuration/ui"
                                ,"/configuration/security"
                                ,"/swagger-ui/**"
                                ,"/webjars/**"
                                ,"/swagger-ui/**"
                                ,"/swagger-ui.html"
                                ,"/api/v1/profiles/**"
                                ,"/api/v1/notifications/**"
                                        ,"/api/v1/notifications"
                                ,"api/v1/plant/**"
                                ,"/api/v1/crops/**"
                                ,"api/v1/CropReports/**"
                                ,"/api/v1/activities/**"
                                ,"/api/v1/contacts/**"
                                ,"/api/v1/messages/**"
                                ,"/api/v1/projects/**")
                                .permitAll()
                                .anyRequest().authenticated()//sdre
                        )
                .sessionManagement(
                        sessionManager->sessionManager.sessionCreationPolicy(SessionCreationPolicy.STATELESS ))
                .authenticationProvider(authProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}
