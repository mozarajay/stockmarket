package com.simplestockmarket.model;

import java.util.Date;

public class Trade {

	private final String symbol;
	private final TradeTransactionType tradeTransactionType;
	private final Double price;
	private final Long sharesQuantity;
	private final Date timestamp;

	private Trade(TradeBuilder builder) {
		this.symbol = builder.symbol;
		this.tradeTransactionType = builder.tradeTransactionType;
		this.price = builder.price;
		this.sharesQuantity = builder.sharesQuantity;
		this.timestamp = builder.timestamp;
	}

	public String getSymbol() {
		return symbol;
	}

	public TradeTransactionType getTradeTransactionType() {
		return tradeTransactionType;
	}

	public Double getPrice() {
		return price;
	}

	public Long getSharesQuantity() {
		return sharesQuantity;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public static class TradeBuilder {
		private String symbol;
		private TradeTransactionType tradeTransactionType;
		private Double price;
		private Long sharesQuantity;
		private Date timestamp;

		public TradeBuilder setSymbol(String symbol) {
			this.symbol = symbol;
			return this;
		}

		public TradeBuilder setTradeTransactionType(TradeTransactionType tradeTransactionType) {
			this.tradeTransactionType = tradeTransactionType;
			return this;
		}

		public TradeBuilder setPrice(Double price) {
			this.price = price;
			return this;
		}

		public TradeBuilder setSharesQuantity(Long sharesQuantity) {
			this.sharesQuantity = sharesQuantity;
			return this;
		}

		public TradeBuilder setTimestamp(Date timestamp) {
			this.timestamp = timestamp;
			return this;
		}

		public Trade build() {
			return new Trade(this);
		}
	}
}
