package com.wipro.ClinicSystem.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.wipro.ClinicSystem.model.Patient;
import com.wipro.ClinicSystem.service.PatientService;


@Controller
@RequestMapping("/patient")
public class PatientController {
	@Autowired
	PatientService patientService;
	
	@Autowired
	AppoinmentController appointment;
	
	@RequestMapping("/menu")
	public String showMenu(Model N)
	{
		N.addAttribute("patient",patientService.findAll());
		return "menu";
	}

	@RequestMapping("/insert")
	public String savePatient(Model N)
	{
		N.addAttribute("patient",new Patient());
		return "patientinsert";	
	}
	@RequestMapping("/saveform")
	public String saveForm(@ModelAttribute("patient") Patient patient, Model m) {
		patientService.savePatient(patient);
		m.addAttribute("msg","Inserted successfully");
		m.addAttribute("list",patientService. findAll());
		return "redirect:/appointment/insert";
	}

	@RequestMapping("/update/{id}")
	public String showInsertForm(@PathVariable("id") int patientId, Model m) {
		Patient patient = patientService.findPatientById(patientId);
		m.addAttribute("patient",patient);
		return "/update";
	}
	@RequestMapping("/update")
	public String updateForm(@ModelAttribute("patient") Patient patient, Model m) {
		patientService.savePatient(patient);
		m.addAttribute("msg","Updated successfully");
		m.addAttribute("list",patientService.findAll());
		return "redirect:/patient/showall";
	}
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") int patientId, Model m) {
		patientService.deletePatient(patientId);
		m.addAttribute("msg","Dept No: "+patientId+" Deleted successfully");
		m.addAttribute("list",patientService.findAll());
		return "redirect:/patient/showall";
	}
	@RequestMapping("/showall")
	public String showAll(Model m, HttpSession sess) {
		m.addAttribute("list",patientService.findAll());
		return "menu";
	}	
	 
}
