package com.demo.m1nuano.website.repository;

import com.demo.m1nuano.website.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {
    Category findByCategoryName(String categoryName);
}
