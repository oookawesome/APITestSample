package com.samsung.apitest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samsung.apitest.model.GetResponse;

@RestController
public class SampleController {
	
	@GetMapping("/test")
	public GetResponse get() {
		return new GetResponse("test");
	}
}
