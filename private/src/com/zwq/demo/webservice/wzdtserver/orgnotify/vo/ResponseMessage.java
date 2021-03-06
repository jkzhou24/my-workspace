package com.zwq.demo.webservice.wzdtserver.orgnotify.vo;

import java.io.Serializable;

public class ResponseMessage implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2168874414452520348L;

	private String state;

	private String content;

	private ErrorMessage errorMessage;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
	}

}
