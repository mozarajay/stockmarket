package com.simplestockmarket.database.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.simplestockmarket.database.StockDao;
import com.simplestockmarket.model.Stock;
import com.simplestockmarket.model.StockType;

/*
 * Inmemory implementation of {@code StockDao}
 */
@Service
public class StockDaoImpl implements StockDao {

	private static Map<String, Stock> stockDB = new ConcurrentHashMap<String, Stock>();

	static {
		stockDB.put("TEA", new Stock.StockBuilder().setStockID(1L).setStockSymbol("TEA").setType(StockType.COMMON)
				.setLastDividend(Double.valueOf(0)).setParValue(Double.valueOf(100)).build());

		stockDB.put("POP", new Stock.StockBuilder().setStockID(2L).setStockSymbol("POP").setType(StockType.COMMON)
				.setLastDividend(Double.valueOf(8)).setParValue(Double.valueOf(100)).build());

		stockDB.put("ALE", new Stock.StockBuilder().setStockID(3L).setStockSymbol("ALE").setType(StockType.COMMON)
				.setLastDividend(Double.valueOf(23)).setParValue(Double.valueOf(60)).build());

		stockDB.put("GIN",
				new Stock.StockBuilder().setStockID(4L).setStockSymbol("GIN").setType(StockType.PREFERRED)
						.setLastDividend(Double.valueOf(8)).setFixedDividend(Double.valueOf(2))
						.setParValue(Double.valueOf(100)).build());

		stockDB.put("JOE", new Stock.StockBuilder().setStockID(5L).setStockSymbol("JOE").setType(StockType.COMMON)
				.setLastDividend(Double.valueOf(13)).setParValue(Double.valueOf(250)).build());
	}

	public void addStock(Stock stock) {
		stockDB.put(stock.getStockSymbol(), stock);
	}

	public Stock getStock(String symbol) {
		return stockDB.get(symbol);
	}
}
