package com.simplestockmarket.model;

public class GetGBCEResponse {

	private Double gbce;

	private GetGBCEResponse(GetGBCEResponseBuilder builder) {
		this.gbce = builder.gbce;
	}

	public Double getGbce() {
		return gbce;
	}

	public void setGbce(Double gbce) {
		this.gbce = gbce;
	}

	public static class GetGBCEResponseBuilder {
		private Double gbce;

		public GetGBCEResponseBuilder setGbce(Double gbce) {
			this.gbce = gbce;
			return this;
		}

		public GetGBCEResponse build() {
			return new GetGBCEResponse(this);
		}
	}
}
