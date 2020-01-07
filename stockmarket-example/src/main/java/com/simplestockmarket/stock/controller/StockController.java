package com.simplestockmarket.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simplestockmarket.exception.ResultCode;
import com.simplestockmarket.model.GetDividendYieldResponse;
import com.simplestockmarket.model.GetPERatioResponse;
import com.simplestockmarket.model.GetVolWeightedResponse;
import com.simplestockmarket.stock.service.StockService;
/*
 * Rest controller for stock calculation-dividendyield,PERatio,VolumeWeightedPrice
 */
@RestController
@RequestMapping("/stockexchange")
public class StockController {
	
	@Autowired
	private StockService stockService;
	
	@RequestMapping(value = "/stock/{symbol}/dividendyield", method = RequestMethod.GET)
	public ResponseEntity<Object> getDividentYield(@RequestParam(required = true) Double stockPrice,
			@PathVariable(required=true, name="symbol") String symbol) {
		if (stockPrice <= 0) {
			 return new ResponseEntity<>(ResultCode.STOCK_INVALID_PARAM, HttpStatus.BAD_REQUEST);
		}
		
		Double dividendYield = stockService.getStockDividendYield(symbol, stockPrice);
		
		GetDividendYieldResponse response = new GetDividendYieldResponse.GetDividendYieldResponseBuilder().setDividendYield(dividendYield)
				.setStockPrice(stockPrice).setSymbol(symbol).build();
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/stock/{symbol}/peratio", method = RequestMethod.GET)
	public ResponseEntity<Object> getPERatio(@RequestParam(required = true) Double stockPrice,
			@PathVariable("symbol") String symbol) {
		if (stockPrice <= 0) {
			return new ResponseEntity<>(ResultCode.STOCK_INVALID_PARAM, HttpStatus.BAD_REQUEST);
		}
		
		Double peRatio = stockService.getStockPERatio(symbol, stockPrice);
		
		GetPERatioResponse response = new GetPERatioResponse.GetPERatioResponseBuilder().setPeRatio(peRatio).setStockPrice(stockPrice)
				.setSymbol(symbol).build();
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/stock/{symbol}/vwprice", method = RequestMethod.GET)
	public ResponseEntity<Object> getVolumeWeightedPrice(@PathVariable("symbol") String symbol) {
		
		Double volWeightedPrice = stockService.getVolumeWeightedStockPrice(symbol);
		
		GetVolWeightedResponse response = new GetVolWeightedResponse.GetVolWeightedResponseBuilder().setSymbol(symbol)
				.setVolWeighedPrice(volWeightedPrice).build();
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
}
