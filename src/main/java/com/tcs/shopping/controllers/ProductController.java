package com.tcs.shopping.controllers;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.shopping.dtos.ProductDto;
import com.tcs.shopping.entities.ProductEntity;
import com.tcs.shopping.services.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public @NotNull Iterable<ProductEntity> list() {
		return this.productService.getAllProducts();
	}

	@PostMapping
	public ResponseEntity<String> create(@RequestBody ProductForm form) {
		List<ProductDto> formDtos = form.getProducts();
		
		for (ProductDto dto : formDtos) {
			productService.save(new ProductEntity(dto.getName(),dto.getPrice(),dto.getPictureUrl()));
		}

		return new ResponseEntity<>("Saved", HttpStatus.CREATED);
	}
	
	public static class ProductForm {

		private List<ProductDto> products;

		public List<ProductDto> getProducts() {
			return products;
		}

		public void setProducts(List<ProductDto> products) {
			this.products = products;
		}
	}
}
