package com.github.brunoonofre64.infra.data.mappers;

import com.github.brunoonofre64.domain.entities.Product;
import com.github.brunoonofre64.infra.data.entities.ProductEntity;

public interface ProductDataMapper {
    Product toDomain(ProductEntity prod);
    ProductEntity toEntity(Product prod);
}
