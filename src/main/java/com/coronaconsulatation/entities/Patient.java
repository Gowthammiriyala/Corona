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
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private String gender;
	private String mobile;
	private String location;
	
	@OneToOne
	@JoinColumn(name = "patientReportId", referencedColumnName = "patientReportId")
	private PatientReport patientReport;
	
	 @OneToOne
	 @JoinColumn(name = "doctorId", referencedColumnName = "D_Id")
	 private Doctor doctor;
	
     @OneToOne
     @JoinColumn(name = "billingId", referencedColumnName = "B_Id")
     private Billing billing;
    
     @OneToOne
     @JoinColumn(name = "feedbackId", referencedColumnName = "F_Id")
     private Feedback feedback;
   
}
