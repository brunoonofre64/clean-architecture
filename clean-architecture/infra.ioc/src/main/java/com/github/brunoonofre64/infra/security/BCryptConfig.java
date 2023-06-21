package com.github.brunoonofre64.infra.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class BCryptConfig {

    @Bean
    public PasswordEncoder bCryptPasswordEncoderBean() {
        return new BCryptPasswordEncoder();
    }
}
