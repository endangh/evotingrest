package com.endang.restEvoting.model;

public class Status {

	private String id;
	private String status;

	public Status() {
		super();
	}

	public Status(String id, String status) {
		super();
		this.id = id;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
