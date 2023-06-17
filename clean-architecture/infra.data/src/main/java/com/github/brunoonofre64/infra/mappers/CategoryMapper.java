package com.github.brunoonofre64.infra.mappers;

import com.github.brunoonofre64.domain.entities.Category;
import com.github.brunoonofre64.domain.entities.Product;
import com.github.brunoonofre64.infra.entitiesrelationship.CategoryEntity;
import com.github.brunoonofre64.infra.entitiesrelationship.ProductEntity;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryMapper {

    public static Category toDomain(CategoryEntity category) {
        List<Product> products = category.getProducts()
                .stream()
                .map(ProductMapper::toDomain)
                .collect(Collectors.toList());

        return new Category(category.getUuid(), category.getName(), products);
    }

    public static CategoryEntity toInfraEntity(Category category) {
        List<ProductEntity> products = category.getProducts()
                .stream()
                .map(ProductMapper::toInfraEntity)
                .collect(Collectors.toList());

        return new CategoryEntity(category.getUuid(), category.getName(), products);
    }
}
