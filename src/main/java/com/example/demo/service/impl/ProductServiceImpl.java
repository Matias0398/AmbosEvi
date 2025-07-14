package com.example.demo.service.impl;

import com.example.demo.entity.Product;
import com.example.demo.repository.IProductRepository;
import com.example.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Override
    public Product save(Product product) {
        product.setActive(true);
        product.setCreatedAt(new Date());
        product.setUpdatedAt(new Date());
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> get(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void update(Product product, Long id) {
        Optional<Product> productOptional = get(id);
        if (productOptional.isEmpty()) {
            throw new IllegalArgumentException("Producto no encontrado");
        }
        Product existingProduct = productOptional.get();
        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setUpdatedAt(new Date());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setSizes(product.getSizes());
        existingProduct.setImageUrl(product.getImageUrl());

        productRepository.save(existingProduct);
    }

    @Override
    public void delete(Long id) {
        Optional<Product> productOptional = get(id);
        if (productOptional.isEmpty()) {
            throw new IllegalArgumentException("Producto no encontrado");
        }
        Product product = productOptional.get();
        product.setActive(false);
        product.setUpdatedAt(new Date());
        productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
