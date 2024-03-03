 package com.wipro.ClinicSystem.controller;


import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wipro.ClinicSystem.model.Doctor;
import com.wipro.ClinicSystem.service.DoctorSerive;

@Controller
@RequestMapping("/doctors")
public class DoctorController {
	@Autowired
	private DoctorSerive doctorSerive;
	
	@RequestMapping("/doctormenu")
	public String showMenu(Model N)
	{
		N.addAttribute("doctor",doctorSerive.findAll());
		return "docotormenu";
	}

	@RequestMapping("/insertdoctor")
	public String saveDoctor(Model N)
	{
		N.addAttribute("doctor",new Doctor());
		return "doctorinsert";	
	}
	@RequestMapping("/saveform")
	public String saveForm(@ModelAttribute("doctor") Doctor doctor, Model m) {
		doctorSerive.saveDoctor(doctor);
		m.addAttribute("msg","Inserted successfully");
		m.addAttribute("list", doctorSerive.findAll());
		return "redirect:/doctors/showall";
	}

	@RequestMapping("/update/{id}")
	public String showInsertForm(@PathVariable("id") int doctorId, Model m) {
		Doctor doctor = doctorSerive.findDoctorById(doctorId);
		m.addAttribute("doctor",doctor);
		return "/upadatedoctordetails";
	}
	@RequestMapping("/update")
	public String updateForm(@ModelAttribute("doctor") Doctor doctor, Model m) {
		doctorSerive.saveDoctor(doctor);
		m.addAttribute("msg","Updated successfully");
		m.addAttribute("list",doctorSerive.findAll());
		return "redirect:/doctors/showall";
	}
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") int doctorId, Model m) {
		doctorSerive.deleteDoctor(doctorId);
		m.addAttribute("msg","Dept No: "+doctorId+" Deleted successfully");
		m.addAttribute("list",doctorSerive.findAll());
		return "redirect:/doctors/showall";
	}
	@RequestMapping("/showall")
	public String showAll(Model m, HttpSession sess) {
		m.addAttribute("list",doctorSerive.findAll());
		return "docotormenu";
	}	
	 
}
