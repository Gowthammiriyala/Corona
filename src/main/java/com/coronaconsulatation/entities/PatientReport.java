package com.coronaconsulatation.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
		  private Patient patient;
		 /* 
		 * @OneToOne
		 * private Doctor doctor;
		 * 
		 * @OneToOne
		 * private Room room;
		 * 
		 * @OneToOne
		 * private Ward ward;
		 * 
		 * 
		 * @OneToOne
		 * private MedicalReport medicalReport;
		 * 
		 
		 */

	
	

	 
}

