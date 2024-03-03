package com.wipro.ClinicSystem.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Appointment {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer appointmentId;
	private String  status;
	private String appointmentDate;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Doctor doctorId;
	@OneToOne(cascade=CascadeType.ALL)
	private Patient patientId;

}
