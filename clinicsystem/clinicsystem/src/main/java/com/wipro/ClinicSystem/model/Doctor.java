package com.wipro.ClinicSystem.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@JsonIgnoreProperties
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Doctor 
{
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
    private Integer docotorId;
    private String  docotorName;
    private String  docotorSpecifiaction;
    private int     docotorExprience;
    private String  gender;
    
    @OneToMany
    private List<Appointment> appointment;
    

     
}
