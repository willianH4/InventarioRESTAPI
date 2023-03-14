package com.williamhdz.inventario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.williamhdz.inventario.models.Product;
import com.williamhdz.inventario.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> listProducts() {
		return productRepository.findAll();
	}
	
	private void saveProduct(Product product) {
		productRepository.save(product);
	}
	
	public Product getProductById(Long id) {
		return productRepository.findById(id).get();
	}
	
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
	
}
