package com.ntdquan.fast_food_ecommerce_backend.Controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ntdquan.fast_food_ecommerce_backend.DTO.ProductDTO;
import com.ntdquan.fast_food_ecommerce_backend.Exception.ProductNotFoundException;
import com.ntdquan.fast_food_ecommerce_backend.Model.Product;
import com.ntdquan.fast_food_ecommerce_backend.Repository.ProductRepository;
import com.ntdquan.fast_food_ecommerce_backend.Service.ProductService;

@RestController
public class ProductController {
	private final ProductService productService;

	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}
	
	@GetMapping("/products")
	public ResponseEntity<List<?>> getAllProduct() {
		List<ProductDTO> products = productService.getAllProducts();
		if(products.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(products);
	}
	
	@PostMapping("/products")
	public ResponseEntity<?> addNewProduct(@RequestBody Product newProduct) {
		Product product = productService.saveProduct(newProduct);
		return ResponseEntity.status(201).body(product);
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
	    try {
	        ProductDTO productDTO = productService.getProductById(id);
	        return ResponseEntity.ok(productDTO);
	    } catch (ProductNotFoundException ex) {
	        return ResponseEntity.notFound().build();
	    }
	}
	
	@PutMapping("/products/{id}")
	public ResponseEntity<?> editProduct(@RequestBody Product newProduct, @PathVariable Long id) {
		Product updatedProduct = productService.updateProduct(id, newProduct);
		return ResponseEntity.ok(updatedProduct);
	}
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
		return ResponseEntity.noContent().build();
	}
	
}
