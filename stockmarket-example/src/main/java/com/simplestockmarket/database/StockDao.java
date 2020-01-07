package com.simplestockmarket.database;

import com.simplestockmarket.model.Stock;

public interface StockDao {

	void addStock(Stock stock);
	
	Stock getStock(String stockSymbol);
}
