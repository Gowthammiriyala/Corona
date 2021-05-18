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
	private Integer patientid;
	private String name;
	private String email;
	private String gender;
	private String mobile;
	private String Location;
	
	@OneToOne
	@JoinColumn(name = "patientReportId", referencedColumnName = "patientReportId")
	private PatientReport patientReport;
	
  /*@OneToOne
   * @JoinColumn(name = "billingId", referencedColumnName = "billing_Id"
   * private Billing billing;
   * 
   * @OneToOne
   * @JoinColumn(name = "feedbackId", referencedColumnName = "feedback_Id"
   * private Feedback feedback;
   */
}
