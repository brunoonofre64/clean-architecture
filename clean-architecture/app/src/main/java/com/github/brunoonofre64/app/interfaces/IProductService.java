package com.github.brunoonofre64.app.interfaces;

import com.github.brunoonofre64.app.dtos.ProductDTO;

import java.util.List;

public interface IProductService {
    ProductDTO save(ProductDTO dto);
    List<ProductDTO> findAll();
    ProductDTO update(String uuid, ProductDTO dto);
    void deleteByUuid(String uuid);
}
