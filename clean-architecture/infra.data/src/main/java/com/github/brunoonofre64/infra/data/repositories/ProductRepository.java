package com.github.brunoonofre64.infra.data.repositories;

import com.github.brunoonofre64.infra.data.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, String> {
    Optional<ProductEntity> findByUuid(String uuid);
    void deleteByUuid(String uuid);
}
