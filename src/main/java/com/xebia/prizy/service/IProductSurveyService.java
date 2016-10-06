package com.xebia.prizy.service;

import com.xebia.prizy.model.SurveyProduct;
import com.xebia.prizy.modelvo.ProductVO;

public interface IProductSurveyService {

	String submitSurveyPrice(SurveyProduct surveyProduct);
	
	ProductVO getProductDetails(String barCode);
}
