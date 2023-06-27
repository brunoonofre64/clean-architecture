package com.github.brunoonofre64.infra.data.repositories;

import com.github.brunoonofre64.infra.data.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, String> {
    Optional<CategoryEntity> findByUuid(String uuid);
    void deleteByUuid(String uuid);
}
