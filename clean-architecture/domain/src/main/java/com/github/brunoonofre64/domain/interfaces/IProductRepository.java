package com.github.brunoonofre64.domain.interfaces;

import com.github.brunoonofre64.domain.entities.Product;

import java.util.Optional;

public interface IProductRepository {
    Optional<Product> findByUuid(String uuid);
    void deleteByUuid(String uuid);
}
