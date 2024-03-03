package com.wipro.ClinicSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/clinichome")
public class ClinicHome
{
	@RequestMapping("")
	public String saveDoctor(Model N)
	{
		return "clinichome";	
	}
}
