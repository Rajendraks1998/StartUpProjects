package com.wipro.ClinicSystem.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wipro.ClinicSystem.model.Schedule;
import com.wipro.ClinicSystem.service.DoctorSerive;
import com.wipro.ClinicSystem.service.ScheduleService;
@Controller
@RequestMapping("/schedule")
public class ScheduleController {
	@Autowired
	private DoctorSerive doctorService;
	@Autowired
	private ScheduleService  scheduleService;
	
	@RequestMapping("/menu")
	public String showMenu(Model N)
	{
		N.addAttribute("schedule",scheduleService.findAll());
		return "schedulemenu";
	}
	@RequestMapping("/insert")
	public String saveAppointment(Model N)
	{
		N.addAttribute("doctors", doctorService.findAll());
		N.addAttribute("schedule",new Schedule());
		return "scheduleinsert";	
	}
	@RequestMapping("/saveform")
	public String saveForm(@ModelAttribute("schedule") Schedule schedule, Model m) {
		scheduleService.saveSchedule(schedule);
		m.addAttribute("msg","Inserted successfully");
		m.addAttribute("list", scheduleService.findAll());
		return "redirect:/schedule/showall";
	}
	@RequestMapping("/update/{id}")
	public String showInsertForm(@PathVariable("id") int scheduleId, Model m) {
		Schedule schedule = scheduleService.findByScheduleId(scheduleId);
		m.addAttribute("schedule",schedule);
		return "scheduleupdate";
	}
	@RequestMapping("/update")
	public String updateForm(@ModelAttribute("schedule") Schedule schedule, Model m) {
		scheduleService.saveSchedule(schedule);
		m.addAttribute("msg","Updated successfully");
		m.addAttribute("list",scheduleService.findAll());
		return "redirect:/schedule/showall";
	}
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") int scheduleId, Model m) {
		scheduleService.deleteSchedule(scheduleId);
		m.addAttribute("msg","Dept No: "+scheduleId+" Deleted successfully");
		m.addAttribute("list",scheduleService.findAll());
		return "redirect:/schedule/showall";
	}
	@RequestMapping("/showall")
	public String showAll(Model m) {
		m.addAttribute("list",scheduleService.findAll());
		return "menu";
	}	

}
