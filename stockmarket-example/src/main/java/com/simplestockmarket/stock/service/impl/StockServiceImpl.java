package com.simplestockmarket.stock.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplestockmarket.calculator.service.StockCalculator;
import com.simplestockmarket.calculator.service.impl.StockCalculatorFactory;
import com.simplestockmarket.exception.ApiException;
import com.simplestockmarket.model.StockCalculatorType;
import com.simplestockmarket.model.Trade;
import com.simplestockmarket.stock.service.StockService;
import com.simplestockmarket.trade.service.TradeService;

@Service
public class StockServiceImpl implements StockService {

	private static final Integer MINUTES = 15;

	@Autowired
	StockCalculatorFactory stockCalculatorFactory;

	@Autowired
	TradeService tradeService;

	@Override
	public Double getStockDividendYield(String stockSymbol, Double stockPrice) {
		return calculate(stockSymbol, stockPrice, StockCalculatorType.DIVIDEND_YIELD);
	}

	@Override
	public Double getStockPERatio(String stockSymbol, Double stockPrice) {
		return calculate(stockSymbol, stockPrice, StockCalculatorType.PE_RATIO);
	}

	private Double calculate(String stockSymbol, Double stockPrice, StockCalculatorType stockCalculatorType) {
		StockCalculator stockCalculator = stockCalculatorFactory.getStockCalculator(stockCalculatorType);
		return stockCalculator.calculate(stockSymbol, stockPrice);
	}

	@Override
	public Double getVolumeWeightedStockPrice(String symbol) {
		List<Trade> trades = tradeService.getTradesInLastMinutes(symbol, MINUTES);
		Double volWeightedPrice = 0d;
		Long quantity = 0l;
		if (trades != null) {
			for (Trade trade : trades) {
				quantity += trade.getSharesQuantity();
				volWeightedPrice += trade.getSharesQuantity() * trade.getPrice();
			}
			volWeightedPrice /= quantity;
		}
		return volWeightedPrice;
	}
}
