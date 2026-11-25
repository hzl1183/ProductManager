package com.example.ProductManagement.repository;

import com.example.ProductManagement.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface productRepository extends JpaRepository<Product, Long> {
}
