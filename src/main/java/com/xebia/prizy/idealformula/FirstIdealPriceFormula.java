package com.xebia.prizy.idealformula;

import java.util.List;

import org.springframework.stereotype.Component;

import com.xebia.prizy.model.SurveyProduct;

@Component("firstIdealPriceFormula")
public class FirstIdealPriceFormula implements IIdealPriceFormula {

	@Override
	public double findIdealPrice(List<SurveyProduct> surveyProducts) {
		double idealPrice = 0;
		double highestPrice = 0;
		double scndhighestPrice = 0;
		double lowestPrice = Double.MAX_VALUE;
		double scndLowestPrice = Double.MAX_VALUE;
		double totalPrice = 0;
		int noOfPrices = 0;
		for (SurveyProduct surveyProduct : surveyProducts) {
			double price = surveyProduct.getPriceByUser();
			if (price > highestPrice) {
				if(highestPrice > scndhighestPrice) {
					scndhighestPrice = highestPrice;
				}
				highestPrice = price;
			} else if (price > scndhighestPrice) {
				scndhighestPrice = price;
			} 
			if (price < lowestPrice) {
				if(lowestPrice < scndLowestPrice) {
					scndLowestPrice = lowestPrice;
				}
				lowestPrice = price;
			} else if (price < scndLowestPrice) {
				scndLowestPrice = price;
			}
			totalPrice += price;
			++noOfPrices;
		}
		if (noOfPrices > 4) {
			// Removing highest 2 and lowest two + Adding 20%
			idealPrice = ((totalPrice - highestPrice - scndhighestPrice - lowestPrice - scndLowestPrice)
					/ (noOfPrices - 4))*1.2;
		} else {
			
			// Adding 20%
			idealPrice = (totalPrice/noOfPrices) * 1.2;
			
		}
		return idealPrice;
	}

}
