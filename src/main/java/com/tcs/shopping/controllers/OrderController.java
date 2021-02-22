package com.tcs.shopping.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tcs.shopping.dtos.OrderDetailsDto;
import com.tcs.shopping.entities.OrderEntity;
import com.tcs.shopping.entities.OrderProductEntity;
import com.tcs.shopping.exceptions.ResourceNotFoundException;
import com.tcs.shopping.services.OrderProductService;
import com.tcs.shopping.services.OrderService;
import com.tcs.shopping.services.ProductService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
	@Autowired
	private ProductService productService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderProductService orderProductService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public @NotNull Map<Long,Date> list() {
		return this.orderService.getAllOrders().stream()
	      .collect(Collectors.toMap(OrderEntity::getId, order -> order.getCreatedOn()));
	
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public @NotNull List<OrderDetailsDto> orderDetailsById(@PathVariable(value = "id") Long id) {
		
		OrderEntity ordEnty= this.orderService.findById(id);
		List<OrderDetailsDto> formDtos=new ArrayList<>();
		OrderDetailsDto ordDet=new OrderDetailsDto();
		formDtos.addAll(
				ordEnty.getOrderProducts().stream().map(prd->{
		ordDet.setProduct(prd.getProduct());
		ordDet.setQuantity(prd.getQuantity());
		return ordDet;
		}).collect(Collectors.toList()));
		//ordEnty.getOrderProducts().get(0).getProduct();
		//return formDtos.addAll(ordEnty.getOrderProducts().stream().map(prd->prd.getProduct()).collect(Collectors.toList()));
	
		
		return formDtos;
	}
	

	@PostMapping
	public ResponseEntity<OrderEntity> create(@RequestBody OrderForm form) {
		List<OrderDetailsDto> formDtos = form.getProductOrders();
		validateProductsExistence(formDtos);
		OrderEntity order = new OrderEntity();
		order.setStatus("PAID");
		order = this.orderService.create(order);

		List<OrderProductEntity> orderProducts = new ArrayList<>();
		for (OrderDetailsDto dto : formDtos) {
			orderProducts.add(orderProductService.create(new OrderProductEntity(order,
					productService.getProduct(dto.getProduct().getId()), dto.getQuantity())));
		}

		order.setOrderProducts(orderProducts);

		this.orderService.update(order);

		String uri = ServletUriComponentsBuilder.fromCurrentServletMapping().path("/orders/{id}")
				.buildAndExpand(order.getId()).toString();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", uri);

		return new ResponseEntity<>(order, headers, HttpStatus.CREATED);
	}

	private void validateProductsExistence(List<OrderDetailsDto> orderProducts) {
		List<OrderDetailsDto> list = orderProducts.stream()
				.filter(op -> Objects.isNull(productService.getProduct(op.getProduct().getId())))
				.collect(Collectors.toList());

		if (!CollectionUtils.isEmpty(list)) {
			new ResourceNotFoundException("Product not found");
		}
	}

	public static class OrderForm {

		private List<OrderDetailsDto> productOrders;

		public List<OrderDetailsDto> getProductOrders() {
			return productOrders;
		}

		public void setProductOrders(List<OrderDetailsDto> productOrders) {
			this.productOrders = productOrders;
		}
	}
}