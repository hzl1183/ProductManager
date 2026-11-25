package com.example.ProductManagement.controller;


import com.example.ProductManagement.dto.ProductDto;
import com.example.ProductManagement.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private ProductService productService;

    @PostMapping
    public ProductDto addProduct(@RequestBody ProductDto productDto){
        return productService.addProduct(productDto);
    }

    @GetMapping
    public List<ProductDto> getAllProduct(){
        return productService.getAllProduct();
    }

    @GetMapping("/{id}")
    public ProductDto getProductByID(@PathVariable Long id){
        return productService.getProductByID(id);
    }
}
