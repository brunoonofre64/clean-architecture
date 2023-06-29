package com.github.brunoonofre64.infra.ioc.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class BCryptConfig {

    @Bean
    public BCryptPasswordEncoder  bCryptPasswordEncoderBean() {
        return new BCryptPasswordEncoder();
    }
}
