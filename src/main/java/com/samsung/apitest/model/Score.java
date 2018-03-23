package com.samsung.apitest.model;

import javax.validation.constraints.NotNull;

import com.samsung.apitest.validator.CreateBinding;

public class Score {
	
	@NotNull(groups = CreateBinding.class)
	private String subject;
	
	@NotNull(groups = CreateBinding.class)
	private Integer point;
	
	public Score() {}
	
	public Score(String subject, Integer point) {
		setSubject(subject);
		setPoint(point);
	}
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Integer getPoint() {
		return point;
	}
	public void setPoint(Integer point) {
		this.point = point;
	}
}
