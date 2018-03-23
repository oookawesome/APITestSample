package com.samsung.apitest.model;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.samsung.apitest.validator.CreateBinding;

import io.swagger.annotations.ApiModelProperty;

public class Student {
	
//	@ApiModelProperty(notes = "the name of student", required = true)
	@NotNull(groups = CreateBinding.class)
	private String name;
	
	@NotNull(groups = CreateBinding.class)
	private Integer id;
	
	@Valid
	@NotNull(groups = CreateBinding.class)
	private List<Score> scores;
	
	public Student() {}
	
	public Student(String name, Integer id, List<Score> scores) {
		this.setName(name);
		this.setId(id);
		this.setScores(scores);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Score> getScores() {
		return scores;
	}

	public void setScores(List<Score> scores) {
		this.scores = scores;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}	
}
