package com.demo.m1nuano.website.repository;

import com.demo.m1nuano.website.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    Product findOneByTitle(String title);
    List<Product> findAllByPriceBetween(int min, int max);
}