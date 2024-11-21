package com.example.app_jeanstation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;
@EnableMethodSecurity(prePostEnabled = true)
@Configuration
public class SecurityConfig {

    private final UserDetailsService userDetailsService;

    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/api/jean-station/placeorder").hasRole("CUSTOMER")
                        .requestMatchers("/api/jean-station/addProduct").hasRole("ADMIN")
                        .requestMatchers("/api/jean-station/addProducts").hasRole("ADMIN")
                        .requestMatchers("/api/jean-station/deleteProduct/{id}").hasRole("ADMIN")
                        .requestMatchers("/api/jean-station/updateProduct/{id}").hasRole("ADMIN")
                        .requestMatchers("/api/jean-station/{id}/release").hasRole("ADMIN")
                        .requestMatchers("/api/jean-station/{id}/deleteOrder").hasRole("CUSTOMER")
                        .requestMatchers("/api/jean-station/**").authenticated()
                        .anyRequest().denyAll()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/perform_login")
                        .defaultSuccessUrl("/home", true)
                        .failureUrl("/login?error=true")
                        .permitAll()
                )
                .httpBasic(withDefaults());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {

        return org.springframework.security.crypto.password.NoOpPasswordEncoder.getInstance();
    }

}
