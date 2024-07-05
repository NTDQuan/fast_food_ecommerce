package com.ntdquan.fast_food_ecommerce_backend.Model;

import java.util.List;
import java.util.Objects;

import com.ntdquan.fast_food_ecommerce_backend.Enum.ProductType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String product_name;
	
	private double price;
	
	private String description;
	
	@OneToMany(mappedBy = "product")
	private List<ProductSize> sizes;
	
	private String img;
	
	@Enumerated(EnumType.STRING)
	private ProductType type;

	public Product() {
		super();
	}

	public Product(Long id, String product_name, double price, String description, List<ProductSize> sizes, String img,
			ProductType type) {
		super();
		this.id = id;
		this.product_name = product_name;
		this.price = price;
		this.description = description;
		this.sizes = sizes;
		this.img = img;
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ProductSize> getSizes() {
		return sizes;
	}

	public void setSizes(List<ProductSize> sizes) {
		this.sizes = sizes;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public ProductType getType() {
		return type;
	}

	public void setType(ProductType type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, id, price, product_name, sizes);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(description, other.description) && Objects.equals(id, other.id)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(product_name, other.product_name) && Objects.equals(sizes, other.sizes);
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", product_name=" + product_name + ", price=" + price + ", description="
				+ description + ", sizes=" + sizes + "]";
	}
	
}
