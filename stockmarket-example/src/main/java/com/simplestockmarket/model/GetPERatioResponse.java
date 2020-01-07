package com.simplestockmarket.model;

public class GetPERatioResponse {

	private String symbol;
	private Double stockPrice;
	private Double peRatio;

	private GetPERatioResponse(GetPERatioResponseBuilder builder) {
		this.symbol = builder.symbol;
		this.stockPrice = builder.stockPrice;
		this.peRatio = builder.peRatio;
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

	public Double getPeRatio() {
		return peRatio;
	}

	public void setPeRatio(Double peRatio) {
		this.peRatio = peRatio;
	}

	public static class GetPERatioResponseBuilder {
		private String symbol;
		private Double stockPrice;
		private Double peRatio;

		public GetPERatioResponseBuilder setSymbol(String symbol) {
			this.symbol = symbol;
			return this;
		}

		public GetPERatioResponseBuilder setStockPrice(Double stockPrice) {
			this.stockPrice = stockPrice;
			return this;
		}

		public GetPERatioResponseBuilder setPeRatio(Double peRatio) {
			this.peRatio = peRatio;
			return this;
		}

		public GetPERatioResponse build() {
			return new GetPERatioResponse(this);
		}
	}
}
