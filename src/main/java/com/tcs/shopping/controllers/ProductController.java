package com.tcs.shopping.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.shopping.entities.ProductEntity;
import com.tcs.shopping.services.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
    private ProductService productService;
    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
   
    @GetMapping(value = "/list")
    public List<ProductEntity> list(){
    	return productService.getAllProducts();
       
    }
   
    @GetMapping(value = "/show/{id}")
    public ResponseEntity<?> showProduct(@PathVariable Integer id){
    	ProductEntity product = productService.getProduct(id);
    	return new ResponseEntity<>(product, HttpStatus.OK);
    	//new ResponseEntity("").
       // return product;
    }
    @PostMapping(value = "/add")
    public ResponseEntity saveProduct(@RequestBody ProductEntity product){
        productService.save(product);
        return new ResponseEntity("Product saved successfully", HttpStatus.OK);
    }
    @PutMapping(value = "/update/{id}")
    public ResponseEntity updateProduct(@PathVariable Integer id, @RequestBody ProductEntity product){
    	ProductEntity storedProduct = productService.getProduct(id);
		/*
		 * storedProduct.setDescription(product.);
		 * storedProduct.setImageUrl(product.getImageUrl());
		 * storedProduct.setPrice(product.getPrice());
		 */
        productService.save(storedProduct);
        return new ResponseEntity("Product updated successfully", HttpStatus.OK);
    }
  
    @DeleteMapping(value="/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
       // productService.deleteProduct(id);
        return new ResponseEntity("Product deleted successfully", HttpStatus.OK);
    }
}