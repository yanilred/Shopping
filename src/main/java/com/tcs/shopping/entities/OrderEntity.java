package com.tcs.shopping.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "t_orders")
public class OrderEntity extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "product_id")
	private Long productId;
	
	@Column(name = "customer_id")
	private Long customerId;
	
	@Column(name = "quntity")
	private Integer quntity;
	
	@Column(name = "price")
	private Integer price;
	
	@Column(name = "amount")
	private Integer amount;
	
	
}
