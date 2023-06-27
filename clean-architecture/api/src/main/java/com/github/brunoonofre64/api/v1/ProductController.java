package com.github.brunoonofre64.api.v1;

import com.github.brunoonofre64.app.dtos.ProductDTO;
import com.github.brunoonofre64.app.interfaces.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ProductDTO save(@RequestBody ProductDTO dto) {
        return productService.save(dto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<ProductDTO> findAll() {
        return productService.findAll();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{uuid}")
    public ProductDTO update(@PathVariable String uuid,
                             @RequestBody ProductDTO dto) {
        return productService.update(uuid, dto);
    }

    @DeleteMapping("/{uuid}")
    public void deleteByUuid(@PathVariable String uuid) {
        productService.deleteByUuid(uuid);
    }
}