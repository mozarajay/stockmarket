package com.simplestockmarket.trade.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.simplestockmarket.model.TradeStockRequest;
import com.simplestockmarket.trade.service.TradeService;
/*
 * Rest controller to record trade
 */
@RestController
@RequestMapping("/stockexchange")
public class TradeController {

	@Autowired
	private TradeService tradeService;
	
	@RequestMapping(value = "/trade", method = RequestMethod.POST)
    public ResponseEntity postTrade(@Valid @RequestBody TradeStockRequest tradeRequest) {
		tradeService.recordTrade(tradeRequest);
		return new ResponseEntity(HttpStatus.OK);
    }
}
