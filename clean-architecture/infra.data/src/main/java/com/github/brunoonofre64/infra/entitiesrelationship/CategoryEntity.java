package com.github.brunoonofre64.infra.entitiesrelationship;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "TB_CATEGORY")
public class CategoryEntity extends EntityBase {

    @OneToMany(mappedBy = "category")
    private List<ProductEntity> products;

    public CategoryEntity(String uuid, String name, List<ProductEntity> products) {
        super(uuid, name);
        this.products = products;
    }

    public CategoryEntity() {
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }
}
