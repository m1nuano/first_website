package com.demo.m1nuano.website.service;

import com.demo.m1nuano.website.model.Product;
import com.demo.m1nuano.website.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private ProductRepo productRepo;
    @Autowired
    public void setProductRepository(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }
    public Page<Product> getAllProducts(Pageable pageable) {
        return productRepo.findAll(pageable);
    }
    public Product getProductById(Long id) {
        if (productRepo.findById(id).isPresent()) {
            return productRepo.findById(id).get();
        }
        return null;
    }
    public Product getProductByTitle(String title) {
        return productRepo.findOneByTitle(title);
    }
    public void deleteProductById(Long id) {
        productRepo.deleteById(id);
    }
    public void addProduct(Product product) {
        productRepo.save(product);
    }
}
