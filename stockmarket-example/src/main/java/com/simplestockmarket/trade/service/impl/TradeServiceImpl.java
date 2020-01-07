package com.simplestockmarket.trade.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplestockmarket.database.StockDao;
import com.simplestockmarket.database.TradeDao;
import com.simplestockmarket.exception.ApiException;
import com.simplestockmarket.exception.ResultCode;
import com.simplestockmarket.model.Trade;
import com.simplestockmarket.model.TradeStockRequest;
import com.simplestockmarket.trade.service.TradeService;

@Service
public class TradeServiceImpl implements TradeService{

	@Autowired
	TradeDao tradeDao;
	
	@Autowired
	StockDao stockDao;
	 
	@Override
	public void recordTrade(TradeStockRequest tradeRequest) {
		Trade trade = new Trade.TradeBuilder().setSymbol(tradeRequest.getSymbol()).setTradeTransactionType(tradeRequest.getTransactionType())
				.setPrice(tradeRequest.getTradePrice()).setSharesQuantity(tradeRequest.getSharesQuantity()).setTimestamp(new Date()).build();
		
		if(null == stockDao.getStock(tradeRequest.getSymbol())) {
			throw new ApiException(ResultCode.STOCK_NOT_FOUND, "Stock ["+tradeRequest.getSymbol()+"] is invalid");
		}
		
		tradeDao.create(tradeRequest.getSymbol(), trade);
	}
	
	@Override
	public List<Trade> getTradesInLastMinutes(String symbol, int minutes) {
		return tradeDao.tradesInlastMinutes(symbol, minutes);
	}

	@Override
	public List<Trade> getAllTrades() {
		return tradeDao.getAllTrades();
	}
}
