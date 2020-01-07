package com.simplestockmarket.stock.service;

public interface StockService {

    Double getStockDividendYield(String stockSymbol, Double stockPrice);

	Double getStockPERatio(String symbol, Double stockPrice);
	
	Double getVolumeWeightedStockPrice(String symbol);
}
