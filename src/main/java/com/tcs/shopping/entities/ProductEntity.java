package com.tcs.shopping.entities;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "t_products")
public class ProductEntity extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Basic(optional = false)
	private String name;

	private Double price;

	private String pictureUrl;

	
	
	public ProductEntity() {}
	public ProductEntity(String name, Double price, String pictureUrl) {
		super();
		this.name = name;
		this.price = price;
		this.pictureUrl = pictureUrl;
		this.setCreatedOn(new Date());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
}