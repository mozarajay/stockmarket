package com.simplestockmarket.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplestockmarket.model.Trade;
import com.simplestockmarket.service.SimpleStockMarketService;
import com.simplestockmarket.trade.service.TradeService;

@Service
public class SimpleStockMarketServiceImpl implements SimpleStockMarketService {

	@Autowired
	private TradeService tradeService;

	@Override
	public Double getGBCE() {
		List<Trade> trades = tradeService.getAllTrades();
		Double gbce = 0d;
		if (trades != null && trades.size() != 0) {
			Double priceProduct = 1d;
			for (Trade trade : trades) {
				priceProduct *= trade.getPrice();
			}
			Double n = (double) trades.size();
			gbce = Math.pow(priceProduct, 1d / n);
		}
		return gbce;
	}
}
