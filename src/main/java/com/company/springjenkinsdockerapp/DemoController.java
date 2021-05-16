package com.company.springjenkinsdockerapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@GetMapping("/demo/{pathVariable}")
	public String getData(@PathVariable String pathVariable) {
		return "Your " + pathVariable + " app is running";		
	}
}