package com.coronaconsulatation.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class PatientReport {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int patientReportid;
	private ServiceType servicetype;
	private Boolean Condition;
		
	@OneToOne
	@JoinColumn(name = "patientId", referencedColumnName = "id")
	private Patient patient;
		  
		  
	@OneToOne
	@JoinColumn(name = "RoomId", referencedColumnName = "R_Id")
	private Room room;
		  
    @OneToOne
    @JoinColumn(name = "WardId", referencedColumnName = "W_Id")
	private Ward ward;
		  
		  
	@OneToOne
	@JoinColumn(name = "MedicalReportId", referencedColumnName = "M_Id")
	private MedicalReport medicalReport;
		  
		 


	
	

	 
}

