package com.edstruments.ProductsAPI.Product.Exception;

public class CustomException extends RuntimeException {

	private int errorCode; 
	private String msg;
	
	public CustomException(ExceptionCode code ) {
		this.errorCode = code.getCode();
		this.msg = code.getMsg();
	}

	public int getErrorCode() {
		return errorCode;
	}

	public String getMsg() {
		return msg;
	} 
	
}
