package com.williamhdz.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.williamhdz.inventario.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	
	
}
