package com.simplestockmarket.calculator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplestockmarket.calculator.service.StockCalculator;
import com.simplestockmarket.model.StockCalculatorType;

/*
 * StockCalculator factory provide calculator depending on calculation type
 */
@Service
public class StockCalculatorFactory {

	@Autowired
	DividendYieldCalculator dividendYieldCalculator;
	@Autowired
	PERatioCalculator peRatioCalculator;
	
	public StockCalculator getStockCalculator(StockCalculatorType stockCalculatorType) {
		switch(stockCalculatorType) {
		case DIVIDEND_YIELD : return dividendYieldCalculator;
		case PE_RATIO: return peRatioCalculator;
		default: return null;	
		}
	}
}
