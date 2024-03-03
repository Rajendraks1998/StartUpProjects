package com.wipro.ClinicSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class PageController {

	@RequestMapping("/page1")
	public String page1(Model m) {
		return "page1";
	}

	@RequestMapping("/page2")
	public String singup(Model m) {
		return "page2";
	}

}
