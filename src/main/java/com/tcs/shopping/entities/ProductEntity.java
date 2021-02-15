package com.tcs.shopping.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
//@AllArgsConstructor
@Entity
@Table(name = "t_products")
public class ProductEntity extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "prdt_name")
	private String productName;
	
	@Column(name = "prdt_type")
	private String productType;
	
	@Column(name = "prdt_units")
	private String productUnits;
	
	@Column(name = "prdt_price")
	private BigDecimal productPrice;
	
	@Column(name = "prdt_desc")
	private String productDescription;
	
	@Column(name = "prdt_img_url")
	private String imageUrl;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductUnits() {
		return productUnits;
	}

	public void setProductUnits(String productUnits) {
		this.productUnits = productUnits;
	}

	public BigDecimal getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	
	
}
