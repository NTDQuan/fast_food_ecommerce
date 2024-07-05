package com.ntdquan.fast_food_ecommerce_backend.DTO;

import java.util.List;

public class ProductDTO {
	private Long id;
	private String description;
	private Double price;
	private String product_name;
	private String img;
	private String type;
	private List<String> size;
	public ProductDTO() {
		super();
	}
	public ProductDTO(Long id, String description, Double price, String product_name, String img, List<String> size, String type) {
		super();
		this.id = id;
		this.description = description;
		this.price = price;
		this.product_name = product_name;
		this.img = img;
		this.size = size;
		this.type = type;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public List<String> getSize() {
		return size;
	}
	public void setSize(List<String> size) {
		this.size = size;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
