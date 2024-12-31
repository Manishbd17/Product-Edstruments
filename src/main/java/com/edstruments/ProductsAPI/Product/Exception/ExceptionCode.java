package com.edstruments.ProductsAPI.Product.Exception;

public enum ExceptionCode implements ErrorCodes {
	
	PRODUCT_NOT_FOUND(notFound,"Product not found"),
	INVALID_REQUEST(invalidInput,"Bad request"); 
	
	private final int code;
	private final String msg;
	
	private ExceptionCode(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	} 
	
	
}
