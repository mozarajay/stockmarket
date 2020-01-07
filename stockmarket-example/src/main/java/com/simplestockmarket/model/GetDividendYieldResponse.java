package com.simplestockmarket.model;

public class GetDividendYieldResponse {

	private String symbol;
	private Double stockPrice;
	private Double dividendYield;
	
	private GetDividendYieldResponse(GetDividendYieldResponseBuilder builder) {
		this.symbol = builder.symbol;
		this.stockPrice = builder.stockPrice;
		this.dividendYield = builder.dividendYield;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public Double getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(Double stockPrice) {
		this.stockPrice = stockPrice;
	}

	public Double getDividendYield() {
		return dividendYield;
	}

	public void setDividendYield(Double dividendYield) {
		this.dividendYield = dividendYield;
	}
	
	public static class GetDividendYieldResponseBuilder {
		private String symbol;
		private Double stockPrice;
		private Double dividendYield;
		
		public GetDividendYieldResponseBuilder setSymbol(String symbol) {
			this.symbol = symbol;
			return this;
		}
		public GetDividendYieldResponseBuilder setStockPrice(Double stockPrice) {
			this.stockPrice = stockPrice;
			return this;
		}
		public GetDividendYieldResponseBuilder setDividendYield(Double dividendYield) {
			this.dividendYield = dividendYield;
			return this;
		}
		public GetDividendYieldResponse build() {
			return new GetDividendYieldResponse(this);
		}
	}
}
