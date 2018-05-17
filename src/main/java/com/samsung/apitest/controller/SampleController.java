package com.samsung.apitest.controller;

import com.samsung.apitest.excepiton.StudentNotFoundException;
import com.samsung.apitest.model.Score;
import com.samsung.apitest.model.Student;
import com.samsung.apitest.model.StudentCreateResponse;
import com.samsung.apitest.model.StudentDeleteResponse;
import com.samsung.apitest.validator.CreateBinding;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Api(tags = {"test TAG"}, description = "test DESC", produces = "application/json")
@RestController
public class SampleController {

	@ApiOperation(value = "get student", nickname = "nickname : get student")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Successfully retrieve student", response = Student.class),
		@ApiResponse(code = 404, message = "Not Found student"),
	})
	@GetMapping("/student/{studentId}")
	@ResponseStatus(HttpStatus.OK)
	public Student retrieve(@PathVariable Integer studentId) {
		if(123 != studentId) {
			throw new StudentNotFoundException("student is not exist!");
		}
		return new Student("Hong Gil Dong", studentId, Arrays.asList(
				new Score("Korean", 100),
				new Score("English", 85))
				);
	}

	@PostMapping("/student")
	@ResponseStatus(HttpStatus.CREATED)
	public StudentCreateResponse register(@Validated(value = CreateBinding.class)
										  @RequestBody Student student) {
		return new StudentCreateResponse(student, "Success to create student!");
	}

	@PutMapping("/student/{studentId}")
	@ResponseStatus(HttpStatus.CREATED)
	public Student update(@PathVariable Integer studentId, @RequestBody Student student) {
		if(123 != studentId) {
			throw new StudentNotFoundException("student is not exist!");
		}
		return student;
	}

	@DeleteMapping("/student/{studentId}")
	@ResponseStatus(HttpStatus.OK)
	public StudentDeleteResponse delete(@PathVariable Integer studentId) {
		if(123 != studentId) {
			throw new StudentNotFoundException("student is not exist!");
		}
		return new StudentDeleteResponse(studentId, "Success to delete student!");
	}
}
