package com.github.brunoonofre64.infra.security;

import com.github.brunoonofre64.app.interfaces.ISecurityService;

public class SecurityServiceImpl implements ISecurityService {


    @Override
    public String encode(String password) {
        return null;
    }

    @Override
    public boolean matches(String rawPassword, String encodedPassword) {
        return false;
    }
}
