package com.ntdquan.fast_food_ecommerce_backend.Advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ntdquan.fast_food_ecommerce_backend.Exception.ProductNotFoundException;

@RestControllerAdvice
public class ProductNotFoundAdvice {
	@ExceptionHandler(ProductNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String productNotFoundHandle(ProductNotFoundException ex) {
		return ex.getMessage();
	}
}
