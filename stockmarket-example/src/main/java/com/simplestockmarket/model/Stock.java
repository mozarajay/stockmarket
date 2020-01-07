package com.simplestockmarket.model;

public class Stock {

	private long stockId;
	private String stockSymbol;
	private StockType type;
	private Double lastDividend;
	private Double fixedDividend;
	private Double parValue;

	private Stock(StockBuilder builder) {
		this.stockId = builder.stockId;
		this.stockSymbol = builder.stockSymbol;
		this.type = builder.type;
		this.lastDividend = builder.lastDividend;
		this.fixedDividend = builder.fixedDividend;
		this.parValue = builder.parValue;
	}

	public long getStockId() {
		return stockId;
	}

	public void setStockId(long stockId) {
		this.stockId = stockId;
	}

	public String getStockSymbol() {
		return stockSymbol;
	}

	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}

	public StockType getType() {
		return type;
	}

	public void setType(StockType type) {
		this.type = type;
	}

	public Double getLastDividend() {
		return lastDividend;
	}

	public void setLastDividend(Double lastDividend) {
		this.lastDividend = lastDividend;
	}

	public Double getFixedDividend() {
		return fixedDividend;
	}

	public void setFixedDividend(Double fixedDividend) {
		this.fixedDividend = fixedDividend;
	}

	public Double getParValue() {
		return parValue;
	}

	public void setParValue(Double parValue) {
		this.parValue = parValue;
	}

	public static class StockBuilder {
		private long stockId;
		private String stockSymbol;
		private StockType type;
		private Double lastDividend;
		private Double fixedDividend;
		private Double parValue;

		public StockBuilder() {

		}

		public StockBuilder setStockID(long stockId) {
			this.stockId = stockId;
			return this;
		}

		public StockBuilder setStockSymbol(String stockSymbol) {
			this.stockSymbol = stockSymbol;
			return this;
		}

		public StockBuilder setType(StockType type) {
			this.type = type;
			return this;
		}

		public StockBuilder setLastDividend(Double lastDividend) {
			this.lastDividend = lastDividend;
			return this;
		}

		public StockBuilder setFixedDividend(Double fixedDividend) {
			this.fixedDividend = fixedDividend;
			return this;
		}

		public StockBuilder setParValue(Double parValue) {
			this.parValue = parValue;
			return this;
		}

		public Stock build() {
			return new Stock(this);
		}
	}
}
