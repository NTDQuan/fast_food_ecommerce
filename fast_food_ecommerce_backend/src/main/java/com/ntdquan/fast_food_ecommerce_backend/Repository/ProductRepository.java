package com.ntdquan.fast_food_ecommerce_backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ntdquan.fast_food_ecommerce_backend.Model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
