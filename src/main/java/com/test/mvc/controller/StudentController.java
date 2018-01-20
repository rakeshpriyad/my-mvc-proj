package com.test.mvc.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.mvc.model.Student;
import com.test.mvc.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studService;

	@GetMapping("/student")
	public String userForm(Locale locale, Model model) {
		model.addAttribute("students", studService.list());
		return "editStudent";
	}
	
	@ModelAttribute("student")
    public Student formBackingObject() {
        return new Student();
    }

	@PostMapping("/addStudent")
	public String saveUser(@ModelAttribute("student") @Valid Student student, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("students",studService.list());
			return "editStudent";
		}
		studService.save(student);
		return "redirect:/student/";
	}
}
