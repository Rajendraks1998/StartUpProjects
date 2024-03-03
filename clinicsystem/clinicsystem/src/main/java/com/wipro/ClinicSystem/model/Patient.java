package com.wipro.ClinicSystem.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@JsonIgnoreProperties
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patient {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	 private	Integer patientId;
	 private	String  patientName;
	 private	String  patientAddress;
	 private	String  patientDob;
	 private	Long    patientContactNum;
	 private	String  patientEmail;
	 private	String  patientSymptoms;
	 private	String  gender;
	 
	 @OneToMany
	    private List<Appointment> appointment;


}
