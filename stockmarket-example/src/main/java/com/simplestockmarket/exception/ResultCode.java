package com.simplestockmarket.exception;

import com.fasterxml.jackson.annotation.JsonFormat;

/*
 * application sepcific result code to provide error details
 */
@JsonFormat (shape = JsonFormat.Shape.OBJECT)
public enum ResultCode implements Code{

	STOCK_INVALID_PARAM(400101, "Stock Price should be greather than zero"), 
	STOCK_NOT_FOUND(400102, "Invalid Stock");

	private int code;
	private String message;

	private ResultCode(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
