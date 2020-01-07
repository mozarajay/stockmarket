package com.simplestockmarket.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.simplestockmarket.model.TradeStockRequest;
import com.simplestockmarket.model.TradeTransactionType;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SimpleStockMarketControllerTest {
	private static ObjectMapper mapper = new ObjectMapper();

	@Autowired
	private MockMvc springmvc;

	@Test
	public void testGetGBCE() throws Exception {
		postTrade("POP", 10l, 10.0);

		postTrade("POP", 20l, 20.0);

		postTrade("TEA", 20l, 15.0);

		postTrade("GIN", 20l, 12.0);

		springmvc.perform(MockMvcRequestBuilders.get("/stockexchange/gbce").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$.gbce").value(Matchers.equalTo(13.774493079968597)));
	}

	private void postTrade(String symbol, Long shareQuantity, Double tradePrice) throws Exception {

		TradeStockRequest request = new TradeStockRequest();
		request.setSharesQuantity(shareQuantity);
		request.setSymbol(symbol);
		request.setTradePrice(tradePrice);
		request.setTransactionType(TradeTransactionType.BUY);

		springmvc.perform(post("/stockexchange/trade").contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(request))).andExpect(status().isOk());
	}
}
