package com.simplestockmarket.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.simplestockmarket.exception.ApiException;
import com.simplestockmarket.exception.ResultCode;


@ControllerAdvice
public class ApiExceptionHandler {

	  @ExceptionHandler(ApiException.class)
	   protected ResponseEntity<Object> handleEntityNotFound(
			   ApiException ex) {
	       return new ResponseEntity<>(ResultCode.STOCK_INVALID_PARAM, HttpStatus.BAD_REQUEST);
	   }
}
