package com.xebia.prizy.testpricecalculator;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import com.xebia.prizy.model.SurveyProduct;
import com.xebia.prizy.pricecalculator.PriceCalculator;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=PriceCalculatorTest.class)
@ComponentScan(basePackages="com.xebia.*")
public class PriceCalculatorTest {
	
	@Autowired
	private PriceCalculator priceCalculator;
	
	private static List<SurveyProduct> surveyProducts = new ArrayList<>();
	
	@BeforeClass
	public static void setup() {
		SurveyProduct surveyProduct_1 = new SurveyProduct();
		SurveyProduct surveyProduct_2 = new SurveyProduct();
		SurveyProduct surveyProduct_3 = new SurveyProduct();
		SurveyProduct surveyProduct_4 = new SurveyProduct();
		SurveyProduct surveyProduct_5 = new SurveyProduct();
		SurveyProduct surveyProduct_6 = new SurveyProduct();
		SurveyProduct surveyProduct_7 = new SurveyProduct();
		SurveyProduct surveyProduct_8 = new SurveyProduct();
		surveyProduct_1.setPriceByUser(100);
		surveyProduct_2.setPriceByUser(200);
		surveyProduct_3.setPriceByUser(300);
		surveyProduct_4.setPriceByUser(400);
		surveyProduct_5.setPriceByUser(350);
		surveyProduct_6.setPriceByUser(210);
		surveyProduct_7.setPriceByUser(110);
		surveyProduct_8.setPriceByUser(10);
		surveyProducts.add(surveyProduct_8);
		surveyProducts.add(surveyProduct_7);
		surveyProducts.add(surveyProduct_6);
		surveyProducts.add(surveyProduct_5);
		surveyProducts.add(surveyProduct_4);
		surveyProducts.add(surveyProduct_3);
		surveyProducts.add(surveyProduct_2);
		surveyProducts.add(surveyProduct_1);
	}

	@Test
	public void testFindAveragePrice() {
		double avgPrice = priceCalculator.findAveragePrice(surveyProducts);
		assertEquals(210, avgPrice, 0.1);
	}
	@Test
	public void testFindHighestPrice() {
		double hstPrice = priceCalculator.findHighestPrice(surveyProducts);
		assertEquals(400, hstPrice, 0);
	}
	@Test
	public void testFindLowestPrice() {
		double lstPrice = priceCalculator.findLowestPrice(surveyProducts);
		assertEquals(10, lstPrice, 0);
	}
	@Test
	public void testFindIdealPrice() {
		double idealPrice = priceCalculator.findIdealPrice(surveyProducts);
		assertEquals(246, idealPrice, 0.01);
	}
}
