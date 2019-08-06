package com.zwq.demo.webservice.wzdtserver.orgnotify.vo;

import java.io.Serializable;

public class ErrorMessage implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7961040980876634320L;

	private String errorCode;

	private String message;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
