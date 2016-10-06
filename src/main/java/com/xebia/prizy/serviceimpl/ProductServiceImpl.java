package com.xebia.prizy.serviceimpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xebia.prizy.Repository.ProductRepository;
import com.xebia.prizy.model.Product;
import com.xebia.prizy.service.IProductService;


@Service("iProductService")
public class ProductServiceImpl implements IProductService{

	@Autowired
	private ProductRepository productRepo;
	
	@Override
	public List<Product> getAllProducts() {
		List<Product> allProductList = new ArrayList<>();
		Iterator<Product> allProductsItr =  productRepo.findAll().iterator();
		while (allProductsItr.hasNext()) {
			Product product = (Product) allProductsItr.next();
			allProductList.add(product);
		}
		return allProductList;
	}

	
	
}
