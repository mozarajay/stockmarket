package com.simplestockmarket.calculator.service;

/*
 * basic interface for stock calculation
 */
public interface StockCalculator {

	public Double calculate(String stockSymbol, Double stockPrice);
}
