package com.wipro.ClinicSystem.controller;


import com.wipro.ClinicSystem.model.Appointment;
import com.wipro.ClinicSystem.service.AppointmentSerive;
import com.wipro.ClinicSystem.service.DoctorSerive;
import com.wipro.ClinicSystem.service.PatientService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/appointment")
public class AppoinmentController {
	
	@Autowired
	private AppointmentSerive appointmentSerive;
	
	@Autowired
	private DoctorSerive doctorService;
	@Autowired
	private PatientService patientService;
	
		@RequestMapping("/menu")
		public String showMenu(Model N)
		{
			N.addAttribute("appointment",appointmentSerive.findAll());
			return "appointmentmenu";
		}

		@RequestMapping("/insert")
		public String saveAppointment(Model N)
		{
			N.addAttribute("doctors", doctorService.findAll());
			N.addAttribute("patients", patientService.findAll());
			N.addAttribute("appointment",new Appointment());
			return "appointmentinsert";	
		}
		@RequestMapping("/saveform")
		public String saveForm(@ModelAttribute("appointment") Appointment appointment, Model m) {
			appointmentSerive.saveAppointment(appointment);
			m.addAttribute("msg","Inserted successfully");
			m.addAttribute("list", appointmentSerive.findAll());
			return "redirect:/appointment/showall";
		}

		@RequestMapping("/update/{id}")
		public String showInsertForm(@PathVariable("id") int appointmentId, Model m) {
			Appointment appointment = appointmentSerive.findByAppointmentId(appointmentId);
			m.addAttribute("appointment",appointment);
			return "/appointmentupadate";
		}
		@RequestMapping("/update")
		public String updateForm(@ModelAttribute("appointment")  Appointment appointment, Model m) {
			appointmentSerive.saveAppointment(appointment);
			m.addAttribute("msg","Updated successfully");
			m.addAttribute("list",appointmentSerive.findAll());
			return "redirect:/appointment/showall";
		}
		@RequestMapping("/delete/{id}")
		public String delete(@PathVariable("id") int appointmentId, Model m) {
			appointmentSerive.deleteAppointment(appointmentId);
			m.addAttribute("msg","Dept No: "+appointmentId+" Deleted successfully");
			m.addAttribute("list",appointmentSerive.findAll());
			return "redirect:/doctors/showall";
		}
		@RequestMapping("/showall")
		public String showAll(Model m, HttpSession sess) {
			m.addAttribute("list",appointmentSerive.findAll());
			System.out.println(appointmentSerive.findAll());
			return "menu";
		}	
		 
	}


