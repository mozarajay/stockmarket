package com.simplestockmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.simplestockmarket.model.GetGBCEResponse;
import com.simplestockmarket.service.SimpleStockMarketService;

/*
 * Restcontroller for calculating gbce 
 */
@RestController
@RequestMapping("/stockexchange")
public class SimpleStockMarketController {

	@Autowired
	private SimpleStockMarketService stockMarketService;

	@RequestMapping(value = "/gbce", method = RequestMethod.GET)
	public GetGBCEResponse getGBCEIndex() {
		Double gbce = stockMarketService.getGBCE();
		GetGBCEResponse response = new GetGBCEResponse.GetGBCEResponseBuilder().setGbce(gbce).build();
		return response;
	}
}
