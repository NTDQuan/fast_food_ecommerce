package com.ntdquan.fast_food_ecommerce_backend.Mapper;

import java.util.stream.Collectors;

import com.ntdquan.fast_food_ecommerce_backend.DTO.ProductDTO;
import com.ntdquan.fast_food_ecommerce_backend.Enum.Size;
import com.ntdquan.fast_food_ecommerce_backend.Model.Product;
import com.ntdquan.fast_food_ecommerce_backend.Model.ProductSize;

public class ProductMapper {
	public static ProductDTO toDTO(Product product) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setId(product.getId());
		productDTO.setDescription(product.getDescription());
		productDTO.setImg(product.getImg());
		productDTO.setPrice(product.getPrice());
		productDTO.setProduct_name(product.getProduct_name());
		try {
			productDTO.setType(product.getType().name());
		} catch (NullPointerException ex) {
			productDTO.setType("");
		}
		productDTO.setSize(
			product.getSizes().stream()
				.map(ProductSize::getSize)
				.map(Size::name)
				.collect(Collectors.toList())
		);
		return productDTO;
	}
}
