package com.github.brunoonofre64.app.interfaces;

public interface ISecurityService {
    String encode(String password);
    boolean matchesPassword(String rawPassword, String encodedPassword);
}
