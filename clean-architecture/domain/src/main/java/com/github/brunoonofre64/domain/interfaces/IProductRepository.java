package com.github.brunoonofre64.domain.interfaces;

import com.github.brunoonofre64.domain.entities.Product;

import java.util.List;
import java.util.Optional;

public interface IProductRepository {
    Product save(Product product);
    List<Product> findAll();
    Optional<Product> findByUuid(String uuid);
    void deleteByUuid(String uuid);
}
