package com.wipro.ClinicSystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Schedule {

	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer scheduleId;
	private String doctor;
	private String scheduleDate;

}
	


