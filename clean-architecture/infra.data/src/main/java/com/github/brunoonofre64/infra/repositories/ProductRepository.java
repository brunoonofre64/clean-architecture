package com.github.brunoonofre64.infra.repositories;

import com.github.brunoonofre64.domain.entities.Product;
import com.github.brunoonofre64.domain.interfaces.IProductRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, String>, IProductRepository {
    @Override
    Optional<Product> findByUuid(String uuid);
    @Override
    void deleteByUuid(String uuid);
}
