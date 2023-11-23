package com.dailydatahub.dailydatahub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dailydatahub.dailydatahub.domain.MainCountDashboard;
import com.dailydatahub.dailydatahub.service.MainService;

import lombok.RequiredArgsConstructor;

@Controller
@CrossOrigin
@RequiredArgsConstructor
public class MainController {


	@Autowired
	private MainService mainService;


    @GetMapping("/")
	public ModelAndView login(Model model) {
		return new ModelAndView("main/login.html");
	}

	@GetMapping("/main")
	public ModelAndView main(Model model) {
		ModelAndView mav = new ModelAndView();
		MainCountDashboard mainCountDashboard = mainService.selectMainCountDashboard().get();
		mav.addObject(mainCountDashboard);
		mav.setViewName("main/main.html");
		return mav;
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
