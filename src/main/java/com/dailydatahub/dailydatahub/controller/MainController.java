package com.dailydatahub.dailydatahub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;

@Controller
@CrossOrigin
@RequiredArgsConstructor
public class MainController {

    @GetMapping("/")
	public ModelAndView login(Model model) {
		return new ModelAndView("main/login.html");
	}

	@GetMapping("/main")
	public ModelAndView main(Model model) {
		return new ModelAndView("main/main.html");
	}

	@GetMapping("/register")
	public ModelAndView register(Model model) {
		return new ModelAndView("main/register.html");
	}

	@GetMapping("/forgotPassword")
	public ModelAndView forgotPassword(Model model) {
		return new ModelAndView("main/forgotPassword.html");
	}
}
