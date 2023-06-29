package com.github.brunoonofre64.infra.data.repositories;

import com.github.brunoonofre64.infra.data.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    boolean existsByUsername(String username);
    Optional<UserEntity> findByUsername(String username);
}
