package com.simplestockmarket.trade.service;

import java.util.List;

import com.simplestockmarket.model.Trade;
import com.simplestockmarket.model.TradeStockRequest;

public interface TradeService {

	void recordTrade(TradeStockRequest tradeRequest);
	
	List<Trade> getTradesInLastMinutes(String symbol, int minutes);

	List<Trade> getAllTrades();

}
