package com.github.brunoonofre64.domain.interfaces;

import com.github.brunoonofre64.domain.entities.User;

import java.util.List;
import java.util.Optional;
public interface IUserRepository {
    Optional<User> findByUsername(String username);
    void save(User user);
    List<User> findAll();
    boolean existsByUsername(String username);
    void delete(User user);
}
