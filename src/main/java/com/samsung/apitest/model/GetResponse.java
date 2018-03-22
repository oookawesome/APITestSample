package com.samsung.apitest.model;

public class GetResponse {

	private String name;
	
	public GetResponse() {
		
	}
	
	public GetResponse(String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
