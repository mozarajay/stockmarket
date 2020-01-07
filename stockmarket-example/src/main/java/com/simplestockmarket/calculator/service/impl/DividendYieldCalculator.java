package com.simplestockmarket.calculator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplestockmarket.calculator.service.StockCalculator;
import com.simplestockmarket.database.StockDao;
import com.simplestockmarket.exception.ApiException;
import com.simplestockmarket.exception.ResultCode;
import com.simplestockmarket.model.Stock;
import com.simplestockmarket.model.StockType;

/*
 * DividendYield Calculator for given stock and given price
 */
@Service
public class DividendYieldCalculator implements StockCalculator {

	@Autowired
	private StockDao stockDao;

	@Override
	public Double calculate(String stockSymbol, Double stockPrice) {
		Stock stock = stockDao.getStock(stockSymbol);
		if (stock == null) {
			throw new ApiException(ResultCode.STOCK_NOT_FOUND, "Stock [" + stockSymbol + "] is invalid");
		}
		Double dividendYield = null;
		if (StockType.COMMON == stock.getType()) {
			dividendYield = stock.getLastDividend() / stockPrice;
		} else {
			dividendYield = (stock.getFixedDividend() * stock.getParValue()) / stockPrice;
		}
		return dividendYield;
	}
}
