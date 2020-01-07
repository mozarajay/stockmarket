package com.simplestockmarket.database;

import java.util.List;

import com.simplestockmarket.model.Trade;

public interface TradeDao {

	Trade create(String key, Trade value);

	List<Trade> tradesInlastMinutes(String key, int minutes);
	
	List<Trade> getAllTrades();
}
