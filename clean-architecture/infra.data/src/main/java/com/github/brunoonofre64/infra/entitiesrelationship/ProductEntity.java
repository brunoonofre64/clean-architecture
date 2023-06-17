package com.github.brunoonofre64.infra.entitiesrelationship;

import javax.persistence.*;

@Entity
@Table(name = "TB_PRODUCT")
public class ProductEntity extends EntityBase{
    @Column
    private String description;

    @Column
    private double price;

    @Column
    private int stock;

    @Column
    private String image;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private CategoryEntity category;

    public ProductEntity(String uuid, String name, String description, double price,
                         int stock, String image, CategoryEntity category) {

        super(uuid, name);
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.image = image;
        this.category = category;
    }

    public ProductEntity() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }
}
