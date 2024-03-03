package com.wipro.ClinicSystem.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wipro.ClinicSystem.dao.AdminDao;
import com.wipro.ClinicSystem.model.Admin;

@Controller
@RequestMapping("/account")
public class AuthController {

	@Autowired
	private com.wipro.ClinicSystem.service.AuthService authService;

	@RequestMapping("/clinic")
	public String clincicHome(Model m) {
		//m.addAttribute("users", new Admin());
			return "clinichome";
	}
	@RequestMapping("/frmsignup")
	public String frmSingup(Model m) {
		m.addAttribute("users", new Admin());
			return "signup";
	}

	@RequestMapping("/signup")
	public String singup(@ModelAttribute("users") Admin users, Model m) {
		authService.save(users);

		m.addAttribute("userDao", new AdminDao());
		return "login";
	}

	@RequestMapping("/frmlogin")
	public String frmLogin(Model m) {
		m.addAttribute("userDao", new AdminDao());
		return "login";
	}

	@RequestMapping("/login")
	public String login(@ModelAttribute("userDao") AdminDao userDao, Model m, HttpSession sess) {
		if (authService.checkLogin(userDao, sess)){
			m.addAttribute("userDao", new AdminDao());
			return "home";
		} else{
			return "invalidLogin";}

	}
	@RequestMapping("/logout")
	public String Logout(Model m,HttpSession sess)
	{
		sess.invalidate();
		return "logout";
	}

}
