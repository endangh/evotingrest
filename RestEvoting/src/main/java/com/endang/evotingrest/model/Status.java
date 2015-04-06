package com.endang.evotingrest.model;

public class Status {

	private String response;
	private String message;

	public Status() {
		super();
		
	}

	public Status(String response, String message) {
		super();
		this.response = response;
		this.message = message;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
}
