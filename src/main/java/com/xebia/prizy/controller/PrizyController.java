package com.xebia.prizy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xebia.prizy.model.Product;
import com.xebia.prizy.model.SurveyProduct;
import com.xebia.prizy.modelvo.ProductVO;
import com.xebia.prizy.service.IProductService;
import com.xebia.prizy.service.IProductSurveyService;

@RestController
public class PrizyController {

	
	@Autowired
	private IProductService productService;
	
	@Autowired
	private IProductSurveyService productSurveyService;
	
	@RequestMapping("/allProducts")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}
	
	@RequestMapping("/product")
	public ProductVO getProduct(@RequestParam(value="code")String barCode) {
		return productSurveyService.getProductDetails(barCode);
	}
	
	@RequestMapping("/submitSurvey")
	public String submitSurveyProduct(@RequestBody SurveyProduct surveyProduct) {
		return productSurveyService.submitSurveyPrice(surveyProduct);
	}
	
}
