package com.github.brunoonofre64.domain.interfaces;

import com.github.brunoonofre64.domain.entities.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryRepository {
    void save(Category category);
    Optional<Category> findByUuid(String uuid);
    List<Category> findAll();
    void deleteByUuid(String uuid);
}
