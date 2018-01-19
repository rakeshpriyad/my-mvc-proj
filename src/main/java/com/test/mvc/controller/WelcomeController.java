package com.test.mvc.controller;

import org.springframework.stereotype.Controller;

@Controller
public class WelcomeController {

	public String helloWorld() {
		return "hello";
	}
}
