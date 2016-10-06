package com.xebia.prizy.idealformula;

import java.util.List;

import com.xebia.prizy.model.SurveyProduct;

public interface IIdealPriceFormula {
	
	double findIdealPrice(List<SurveyProduct> surveyProducts);
}
