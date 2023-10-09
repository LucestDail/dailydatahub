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

	// @GetMapping("/error")
	// public ModelAndView error(Model model) {
	// 	return new ModelAndView("main/error.html");
	// }
}
