package com.example.ProductManagement.mapper;

import com.example.ProductManagement.dto.ProductDto;
import com.example.ProductManagement.entity.Product;

public class ProductMapper {

    public static ProductDto maptoProductDto(Product product){
        return new ProductDto(product.getId(),product.getName(),product.getCategory(),product.getPrice(),product.getWeight());
    }

    public static Product maptoProduct(ProductDto productDto){
        return new Product(productDto.getId(),productDto.getName(),productDto.getCategory(),productDto.getPrice(),productDto.getWeight());
    }
}
