package com.simplestockmarket.database.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.simplestockmarket.database.TradeDao;
import com.simplestockmarket.exception.ApiException;
import com.simplestockmarket.exception.ResultCode;
import com.simplestockmarket.model.Trade;

/*
 * Inmemory implementation of {@code StockDao}
 */
@Service
public class TradeDaoImpl implements TradeDao {

	private static Map<String, List<Trade>> tradeDB = new ConcurrentHashMap<String, List<Trade>>();

	@Override
	public Trade create(String key, Trade value) {
		List<Trade> trades = tradeDB.get(key);
		if (trades == null) {
			trades = new ArrayList<Trade>();
		}
		trades.add(value);
		tradeDB.put(key, trades);
		return value;
	}

	@Override
	public List<Trade> tradesInlastMinutes(String key, int minutes) {
		Date date = new Date();
		long time = date.getTime() - (minutes * 60 * 1000);
		List<Trade> listTrades = tradeDB.get(key);
		if (listTrades == null) {
			throw new ApiException(ResultCode.STOCK_NOT_FOUND, "Stock ["+key+"] is invalid");
		}
		List<Trade> tradesInLastMinutes = null;
		if (listTrades != null)
			tradesInLastMinutes = listTrades.stream().filter(entity -> entity.getTimestamp().getTime() >= time)
					.collect(Collectors.toList());
		return tradesInLastMinutes;
	}

	@Override
	public List<Trade> getAllTrades() {
		List<Trade> trades = new ArrayList<>(tradeDB.values()).stream().flatMap(List::stream).collect(Collectors.toList());
		return trades;
	}
}
