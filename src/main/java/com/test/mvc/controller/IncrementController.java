package com.test.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.mvc.service.IncrementService;

@RestController
public class IncrementController {

	@Autowired
	private IncrementService incrementService;

	@PostMapping("/increment")
	public void increment() {
		incrementService.save(null);
	}

}
