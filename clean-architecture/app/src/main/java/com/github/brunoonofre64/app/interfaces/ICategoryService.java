package com.github.brunoonofre64.app.interfaces;

import com.github.brunoonofre64.app.dtos.CategoryDTO;

import java.util.List;

public interface ICategoryService {
    CategoryDTO save(CategoryDTO dto);
    List<CategoryDTO> findAll();
    CategoryDTO update(String uuid, CategoryDTO dto);
    void deleteByUuid(String uuid);
}
