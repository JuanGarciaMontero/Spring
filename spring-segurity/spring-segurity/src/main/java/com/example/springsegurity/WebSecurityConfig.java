package com.example.springsegurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends EnableWebSecurity {
    public WebSecurityConfig() {

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http.authorizeRequests().antMatchers("/public/**").permitAll().anyRequest()
                    .hasRole("USER").and()
                    // Possibly more configuration ...
                    .formLogin() // enable form based log in
                    // set permitAll for all URLs associated with Form Login
                    .permitAll();
            return http.build();
    }
}
