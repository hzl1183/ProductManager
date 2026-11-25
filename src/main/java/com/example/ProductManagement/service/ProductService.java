package com.example.ProductManagement.service;

import com.example.ProductManagement.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto addProduct(ProductDto productDto);
    List<ProductDto> getAllProduct();
    ProductDto getProductByID(Long id);
    }
