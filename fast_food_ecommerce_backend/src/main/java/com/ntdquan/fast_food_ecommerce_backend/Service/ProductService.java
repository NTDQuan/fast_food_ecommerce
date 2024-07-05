package com.ntdquan.fast_food_ecommerce_backend.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ntdquan.fast_food_ecommerce_backend.DTO.ProductDTO;
import com.ntdquan.fast_food_ecommerce_backend.Exception.ProductNotFoundException;
import com.ntdquan.fast_food_ecommerce_backend.Mapper.ProductMapper;
import com.ntdquan.fast_food_ecommerce_backend.Model.Product;
import com.ntdquan.fast_food_ecommerce_backend.Model.ProductSize;
import com.ntdquan.fast_food_ecommerce_backend.Repository.ProductRepository;
import com.ntdquan.fast_food_ecommerce_backend.Repository.ProductSizeRepository;

@Service
public class ProductService {
	private final ProductRepository productRepository;
	private final ProductSizeRepository productSizeRepository;
	
	public ProductService(ProductRepository productRepository, ProductSizeRepository productSizeRepository) {
		this.productRepository = productRepository;
		this.productSizeRepository = productSizeRepository;
	}
	
	public Product saveProduct(Product product) {
		Product savedProduct = productRepository.save(product);
		for (ProductSize size : product.getSizes()) {
			size.setProduct(savedProduct);
			productSizeRepository.save(size);
		}
		return savedProduct;
	}
	
	public List<ProductDTO> getAllProducts() {
		List<Product> products = productRepository.findAll();
		return products.stream().map(ProductMapper::toDTO).collect(Collectors.toList());
	}
	
	public ProductDTO getProductById(Long id) {
		return ProductMapper.toDTO(productRepository.findById(id).get());
	}
	
	public Product updateProduct(Long id, Product updatedProduct) {
		Optional<Product> existingProduct = productRepository.findById(id);
		if(existingProduct.isPresent()) {
			Product product = existingProduct.get();
			product.setProduct_name(updatedProduct.getProduct_name());
			product.setPrice(updatedProduct.getPrice());
			product.setDescription(updatedProduct.getDescription());
			product.setImg(updatedProduct.getImg());
			productSizeRepository.deleteAll(product.getSizes());
            product.setSizes(updatedProduct.getSizes());
            for (ProductSize size : product.getSizes()) {
                size.setProduct(product);
                productSizeRepository.save(size);
            }
            product.setType(updatedProduct.getType());
			return productRepository.save(product);
		} else {
			throw new ProductNotFoundException(id);
		}
	}
	
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
}
