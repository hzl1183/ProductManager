package com.example.ProductManagement.service;

import com.example.ProductManagement.dto.ProductDto;
import com.example.ProductManagement.entity.Product;
import com.example.ProductManagement.exception.ResourcesNotFoundException;
import com.example.ProductManagement.mapper.ProductMapper;
import com.example.ProductManagement.repository.productRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final productRepository productRepository;

    @Override
    public ProductDto addProduct(ProductDto productDto){
        Product product = ProductMapper.maptoProduct(productDto);
        Product savedProduct = productRepository.save(product);

        return ProductMapper.maptoProductDto(savedProduct);
    }

    @Override
    public List<ProductDto> getAllProduct(){
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(ProductMapper::maptoProductDto)
                .toList();
    }

    @Override
    public ProductDto getProductByID(Long id){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourcesNotFoundException("Product not found with id: " + id));
        return ProductMapper.maptoProductDto(product);
    }
}
