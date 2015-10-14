package com.doublev2v.foundation.validate;

@SuppressWarnings("serial")
public class ValidateException extends Exception {

	public ValidateException(Throwable cause) {
		super(cause);
	}
	
	public ValidateException(String message) {
		super(message);
	}
}
