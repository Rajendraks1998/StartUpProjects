package com.wipro.ClinicSystem.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.wipro.ClinicSystem.model.Schedule;
import com.wipro.ClinicSystem.repository.ScheduleRepository;
import com.wipro.ClinicSystem.service.ScheduleService;
@Service
public class ScheduleServiceImpl implements ScheduleService{

	@Autowired
	private ScheduleRepository scheduleRepositroy;
	
	@Override
	public List<Schedule> findAll() {
		
		return scheduleRepositroy.findAll();
	}
	@Override
	public Schedule saveSchedule(Schedule schedule) {
		return scheduleRepositroy.save(schedule);
	}
	@Override
	public Schedule findByScheduleId(int id) {
		return scheduleRepositroy.findByScheduleId(id);
	}
	@Override
	public void deleteSchedule(int id) {
		scheduleRepositroy.deleteById(id);
	}
	@Override
	public Schedule updateSchedule(Schedule schedule) {
		return scheduleRepositroy.save(schedule);
	}

}
