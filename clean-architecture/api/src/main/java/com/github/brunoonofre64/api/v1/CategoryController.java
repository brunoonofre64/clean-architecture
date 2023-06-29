package com.github.brunoonofre64.api.v1;

import com.github.brunoonofre64.app.dtos.CategoryDTO;
import com.github.brunoonofre64.app.interfaces.ICategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final ICategoryService categoryService;

    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public CategoryDTO save(@RequestBody CategoryDTO dto) {
        return categoryService.save(dto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<CategoryDTO> findAll() {
        return categoryService.findAll();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{uuid}")
    public CategoryDTO update(@PathVariable String uuid, @RequestBody CategoryDTO dto) {
        return categoryService.update(uuid, dto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{uuid}")
    public void deleteByUuid(@PathVariable String uuid) {
        categoryService.deleteByUuid(uuid);
    }
}
