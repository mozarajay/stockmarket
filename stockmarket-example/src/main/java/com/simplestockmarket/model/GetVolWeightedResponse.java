package com.simplestockmarket.model;

public class GetVolWeightedResponse {
	private String symbol;
	private Double volWeighedPrice;

	private GetVolWeightedResponse(GetVolWeightedResponseBuilder builder) {
		this.symbol = builder.symbol;
		this.volWeighedPrice = builder.volWeighedPrice;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public Double getVolWeighedPrice() {
		return volWeighedPrice;
	}

	public void setVolWeighedPrice(Double volWeighedPrice) {
		this.volWeighedPrice = volWeighedPrice;
	}

	public static class GetVolWeightedResponseBuilder {
		private String symbol;
		private Double volWeighedPrice;

		public GetVolWeightedResponseBuilder setSymbol(String symbol) {
			this.symbol = symbol;
			return this;
		}

		public GetVolWeightedResponseBuilder setVolWeighedPrice(Double volWeighedPrice) {
			this.volWeighedPrice = volWeighedPrice;
			return this;
		}

		public GetVolWeightedResponse build() {
			return new GetVolWeightedResponse(this);
		}
	}
}
