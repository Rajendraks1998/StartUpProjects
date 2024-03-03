package com.wipro.ClinicSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.ClinicSystem.model.Schedule;
@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer>{

	Schedule findByScheduleId(int id);

}
