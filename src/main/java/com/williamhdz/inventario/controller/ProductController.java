package com.williamhdz.inventario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.williamhdz.inventario.models.Product;
import com.williamhdz.inventario.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	public List<Product> listProducts() {
		return productService.listProducts();
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id) {
		try {
			Product product = productService.getProductById(id);
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/products")
	public void saveProduct(@RequestBody Product product) {
		productService.saveProduct(product);
	}
	
	@PutMapping("/products/{id}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable Long id) {
		try {
			Product productExist = productService.getProductById(id);
			
			productExist.setName(product.getName());
			productExist.setPrice(product.getPrice());
			
			productService.saveProduct(productExist);
			return new ResponseEntity<Product>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/products/{id}")
	public void deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
	}
}
