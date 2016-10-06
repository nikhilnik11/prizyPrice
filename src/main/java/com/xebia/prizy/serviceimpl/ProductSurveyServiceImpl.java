package com.xebia.prizy.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xebia.prizy.Repository.ProductRepository;
import com.xebia.prizy.Repository.SurveyProductRepository;
import com.xebia.prizy.model.Product;
import com.xebia.prizy.model.SurveyProduct;
import com.xebia.prizy.modelvo.ProductVO;
import com.xebia.prizy.pricecalculator.PriceCalculator;
import com.xebia.prizy.service.IProductSurveyService;

@Service("iProductSurveyService")
public class ProductSurveyServiceImpl implements IProductSurveyService{
	
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private SurveyProductRepository surveyProductRepository;
	
	@Autowired
	private PriceCalculator priceCalculator;
	
	@Override
	public String submitSurveyPrice(SurveyProduct surveyProduct) {
		String status = "FAILED";
		SurveyProduct savedPrduct = surveyProductRepository.save(surveyProduct);
		if(savedPrduct != null) {
			status = "SUCCESS";
		}
		return status;
	}
	
	public ProductVO getProductDetails(String barCode) {
		 ProductVO productVO = new ProductVO();
		 Product product = productRepository.findByBarCode(barCode);
		 if(product != null) {
			 List<SurveyProduct> allSurveyProducts = surveyProductRepository.findByProductBarCode(barCode);
			 int noOfSurveys = allSurveyProducts.size();
			 if(noOfSurveys != 0) {
				 double avgPrice = priceCalculator.findAveragePrice(allSurveyProducts);
				 double highPrice = priceCalculator.findHighestPrice(allSurveyProducts);
				 double lowPrice = priceCalculator.findLowestPrice(allSurveyProducts);
				 double idealPrice = priceCalculator.findIdealPrice(allSurveyProducts);
				 productVO.setAvgPrice(avgPrice);
				 productVO.setIdealPrice(idealPrice);
				 productVO.setLowestPrice(lowPrice);
				 productVO.setHighestPrice(highPrice);
				 productVO.setNoOfPrices(noOfSurveys);
			 } else {
				 productVO.setInstructions("Please take some survey first");
			 }
			 productVO.setBarCode(product.getBarCode());
			 productVO.setDescription(product.getDiscription());
		 } else {
			 productVO.setInstructions("No Product with Bar code : "+barCode);
		 }
		 
		 return productVO;
	}
}
