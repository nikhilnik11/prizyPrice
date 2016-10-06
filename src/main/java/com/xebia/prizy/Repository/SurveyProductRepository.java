package com.xebia.prizy.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.xebia.prizy.model.Product;
import com.xebia.prizy.model.SurveyProduct;

public interface SurveyProductRepository extends CrudRepository<SurveyProduct, Long> {
	
	List<SurveyProduct> findByProduct(Product product);
	
	List<SurveyProduct> findByProductBarCode(String barCode);

}
