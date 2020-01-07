package com.simplestockmarket.stock.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.simplestockmarket.exception.ResultCode;
import com.simplestockmarket.model.TradeStockRequest;
import com.simplestockmarket.model.TradeTransactionType;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StockControllerTest {

	private static ObjectMapper mapper = new ObjectMapper();

	@Autowired
	private MockMvc springmvc;

	@Test
	public void testGetDividendYieldWithNoPrice() throws Exception {
		springmvc.perform(
				MockMvcRequestBuilders.get("/stockexchange/stock/POP/dividendyield").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());
	}

	@Test
	public void testGetDividendYieldWithNegativePrice() throws Exception {
		springmvc.perform(MockMvcRequestBuilders.get("/stockexchange/stock/POP/dividendyield?stockPrice=-10")
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());
	}

	@Test
	public void testGetDividendYieldWithInvalidStock() throws Exception {
		springmvc.perform(
				MockMvcRequestBuilders.get("/stockexchange/stock/XXX/dividendyield?stockPrice=10").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());
	}

	@Test
	public void testGetDividendYield() throws Exception {
		springmvc
				.perform(MockMvcRequestBuilders.get("/stockexchange/stock/POP/dividendyield?stockPrice=10")
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$.dividendYield").value(Matchers.equalTo(0.8)))
				.andExpect(jsonPath("$.symbol").value(Matchers.equalTo("POP")));
	}

	@Test
	public void testGetPERatioWithNoPrice() throws Exception {
		springmvc.perform(
				MockMvcRequestBuilders.get("/stockexchange/stock/POP/peratio").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());
	}

	@Test
	public void testGetPERatioWithNegativePrice() throws Exception {
		springmvc.perform(MockMvcRequestBuilders.get("/stockexchange/stock/POP/peratio?stockPrice=-4")
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());
	}

	@Test
	public void testGetPERatioWithInvalidStock() throws Exception {
		springmvc.perform(
				MockMvcRequestBuilders.get("/stockexchange/stock/XXX/peratio?stockPrice=4").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());
	}

	@Test
	public void testGetPERatio() throws Exception {
		springmvc
				.perform(MockMvcRequestBuilders.get("/stockexchange/stock/POP/peratio?stockPrice=4")
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$.peRatio").value(Matchers.equalTo(2.0)))
				.andExpect(jsonPath("$.symbol").value(Matchers.equalTo("POP")));
	}

	@Test
	public void testGetVolWeightedWithInvalidSymbol() throws Exception {
		postTrade("POP", 10l, 10.0);

		postTrade("POP", 20l, 20.0);

		springmvc.perform(
				MockMvcRequestBuilders.get("/stockexchange/stock/POP1/vwprice").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());
	}

	@Test
	public void testGetVolWeightedStockPrice() throws Exception {
		postTrade("POP", 40l, 25.0);

		postTrade("POP", 60l, 35.0);

		springmvc
				.perform(MockMvcRequestBuilders.get("/stockexchange/stock/POP/vwprice")
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$.volWeighedPrice").value(Matchers.equalTo(31.0)))
				.andExpect(jsonPath("$.symbol").value(Matchers.equalTo("POP")));
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
