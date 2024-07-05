package com.ntdquan.fast_food_ecommerce_backend.Exception;

public class ProductNotFoundException extends RuntimeException {
	public ProductNotFoundException(Long id) {
		super("Could not find product " + id);
	}
}
