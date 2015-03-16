package com.endang.restEvoting.model;

public class Status {

	private String response;
	private String error;

	public Status() {
		super();
		
	}

	public Status(String response, String error) {
		super();
		this.response = response;
		this.error = error;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	

}
