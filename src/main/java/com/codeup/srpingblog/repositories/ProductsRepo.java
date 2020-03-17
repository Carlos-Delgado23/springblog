package com.codeup.srpingblog.repositories;

import com.codeup.srpingblog.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepo extends JpaRepository<Product, Long> {
}
