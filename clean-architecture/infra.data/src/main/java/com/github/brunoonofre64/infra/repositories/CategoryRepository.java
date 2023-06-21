package com.github.brunoonofre64.infra.repositories;

import com.github.brunoonofre64.domain.entities.Category;
import com.github.brunoonofre64.domain.interfaces.ICategoryRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String>, ICategoryRepository {
    @Override
    void deleteByUuid(String uuid);
    @Override
    List<Category> findAll();
}
