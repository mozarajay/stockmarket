package com.simplestockmarket.calculator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplestockmarket.calculator.service.StockCalculator;

/*
 * PERatio Calculator for given stock and given price
 */
@Service
public class PERatioCalculator implements StockCalculator {

	@Autowired
	DividendYieldCalculator dividendYieldCalculator;

	@Override
	public Double calculate(String stockSymbol, Double stockPrice) {
		Double dividendYield = dividendYieldCalculator.calculate(stockSymbol, stockPrice);
		Double peRatio = stockPrice / dividendYield;
		return peRatio;
	}
}
