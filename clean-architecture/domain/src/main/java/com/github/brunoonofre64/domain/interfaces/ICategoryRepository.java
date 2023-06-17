package com.github.brunoonofre64.domain.interfaces;

import com.github.brunoonofre64.domain.entities.Category;

import java.util.Optional;

public interface ICategoryRepository {
    Optional<Category> findByUuid(String uuid);
    void deleteByUuid(String uuid);
}
