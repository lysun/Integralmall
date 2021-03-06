package com.doublev2v.foundation.core.rest;

public class ErrorCodeException extends RuntimeException {

	private static final long serialVersionUID = -7415698938205987151L;
	
	private ErrorCode errorCode;

	public ErrorCodeException(ErrorCode errorCode) {
		super(errorCode.getError());
		setErrorCode(errorCode);
	}
	
	public ErrorCodeException(ErrorCode errorCode, String message) {
		super(message);
		setErrorCode(errorCode);
	}
	
	public ErrorCodeException(ErrorCode errorCode, Throwable cause) {
		super(cause);
		setErrorCode(errorCode);
	}
	/**
	 * @return the errorCode
	 */
	public ErrorCode getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}
}
