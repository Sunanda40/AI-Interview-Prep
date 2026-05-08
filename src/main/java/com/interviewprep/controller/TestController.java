package com.interviewprep.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	@GetMapping("/")
	public String home() {
		return "AI-Based Interview Preparation Backend is Running";
	}
	@GetMapping("/test")
    public String test() {
        return "Phase 1 setup completed successfully";
    }

}
