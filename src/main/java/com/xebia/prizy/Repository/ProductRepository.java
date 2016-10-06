package com.xebia.prizy.Repository;

import org.springframework.data.repository.CrudRepository;

import com.xebia.prizy.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	Product findByBarCode(String barCode);
}
