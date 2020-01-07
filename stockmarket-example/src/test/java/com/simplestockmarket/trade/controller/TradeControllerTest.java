package com.simplestockmarket.trade.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.simplestockmarket.model.TradeStockRequest;
import com.simplestockmarket.model.TradeTransactionType;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TradeControllerTest {

    private static ObjectMapper mapper = new ObjectMapper();
    
    @Autowired
    private MockMvc springmvc;

    @Test
    public void postTradeWithInvalidSymbol() throws Exception {
        TradeStockRequest request = new TradeStockRequest();
        request.setSharesQuantity(50l);
        request.setSymbol("XXX");
        request.setTradePrice(20.0);
        request.setTransactionType(TradeTransactionType.BUY);
        
        springmvc.perform(
                post("/stockexchange/trade")
                .contentType(MediaType.APPLICATION_JSON)
    			.content(mapper.writeValueAsString(request))
            )
                .andExpect(status().isBadRequest());
    }

    
    @Test
    public void postTrade() throws Exception {
        TradeStockRequest request = new TradeStockRequest();
        request.setSharesQuantity(40l);
        request.setSymbol("POP");
        request.setTradePrice(22.0);
        request.setTransactionType(TradeTransactionType.BUY);
       
        springmvc.perform(
                post("/stockexchange/trade")
                .contentType(MediaType.APPLICATION_JSON)
    			.content(mapper.writeValueAsString(request)))
                .andExpect(status().isOk());
    }
    
}
