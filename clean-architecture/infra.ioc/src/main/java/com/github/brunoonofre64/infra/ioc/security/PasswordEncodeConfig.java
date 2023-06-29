package com.github.brunoonofre64.infra.ioc.security;

import com.github.brunoonofre64.app.interfaces.ISecurityService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncodeConfig implements ISecurityService {
    private final BCryptPasswordEncoder passwordEncoder;

    public PasswordEncodeConfig(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String encode(String password) {
        return passwordEncoder.encode(password);
    }

    @Override
    public boolean matchesPassword(String rawPassword, String encodedPassword) {
        return !passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
