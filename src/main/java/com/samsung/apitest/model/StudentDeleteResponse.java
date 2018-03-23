package com.samsung.apitest.model;

public class StudentDeleteResponse {
	
	private Integer id;
	private String message;

	public StudentDeleteResponse(Integer id, String message) {
		setId(id);
		setMessage(message);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
