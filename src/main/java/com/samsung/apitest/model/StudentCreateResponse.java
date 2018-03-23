package com.samsung.apitest.model;

public class StudentCreateResponse {
	
	private Student student;
	private String message;
	
	public StudentCreateResponse() {}
	
	public StudentCreateResponse(Student student, String message) {
		setStudent(student);
		setMessage(message);
	}
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
