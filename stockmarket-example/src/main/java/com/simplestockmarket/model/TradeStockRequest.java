package com.simplestockmarket.model;

public class TradeStockRequest {

	private String symbol;
	private TradeTransactionType transactionType;
	private Double tradePrice;
	private Long sharesQuantity;

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public TradeTransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TradeTransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public Double getTradePrice() {
		return tradePrice;
	}

	public void setTradePrice(Double tradePrice) {
		this.tradePrice = tradePrice;
	}

	public Long getSharesQuantity() {
		return sharesQuantity;
	}

	public void setSharesQuantity(Long sharesQuantity) {
		this.sharesQuantity = sharesQuantity;
	}

}
