package com.github.brunoonofre64.infra.mappers;

import com.github.brunoonofre64.domain.entities.Product;
import com.github.brunoonofre64.infra.entitiesrelationship.ProductEntity;

public class ProductMapper {

    public static Product toDomain(ProductEntity prod) {
        return new Product(prod.getUuid(), prod.getName(), prod.getDescription(),
                prod.getPrice(), prod.getStock(), prod.getImage());
    }

    public static ProductEntity toInfraEntity(Product prod) {
        return new ProductEntity(prod.getUuid(), prod.getName(), prod.getDescription(), prod.getPrice(), prod.getStock(), prod.getImage(), null);
    }
}
