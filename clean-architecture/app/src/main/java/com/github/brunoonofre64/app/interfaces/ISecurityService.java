package com.github.brunoonofre64.app.interfaces;

public interface ISecurityService {
    String encode(String password);
    boolean matches(String rawPassword, String encodedPassword);
}
