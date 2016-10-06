package com.xebia.prizy.pricecalculator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.xebia.prizy.idealformula.IIdealPriceFormula;
import com.xebia.prizy.model.SurveyProduct;

@Component
public class PriceCalculator {

	@Autowired
	@Qualifier("firstIdealPriceFormula")
	private IIdealPriceFormula idealPriceFormula;

	public double findIdealPrice(List<SurveyProduct> surveyProducts) {

		return idealPriceFormula.findIdealPrice(surveyProducts);

	}

	public double findLowestPrice(List<SurveyProduct> surveyProducts) {
		double lowestPrice = Double.MAX_VALUE;
		for (SurveyProduct surveyProduct : surveyProducts) {
			double price = surveyProduct.getPriceByUser();
			if (price < lowestPrice) {
				lowestPrice = price;
			}
		}
		if(surveyProducts.size() == 0) {
			lowestPrice = 0;
		}
		return lowestPrice;
	}
	
	public double findHighestPrice(List<SurveyProduct> surveyProducts) {
		double highest = 0;
		for (SurveyProduct surveyProduct : surveyProducts) {
			double price = surveyProduct.getPriceByUser();
			if (price > highest) {
				highest = price;
			}
		}
		return highest;
	}
	
	public double findAveragePrice(List<SurveyProduct> surveyProducts) {
		double totalPrice = 0;
		int noOfPrices = 0;
		for (SurveyProduct surveyProduct : surveyProducts) {
			totalPrice += surveyProduct.getPriceByUser();
			noOfPrices++;
		}
		return totalPrice/noOfPrices;
	}
}