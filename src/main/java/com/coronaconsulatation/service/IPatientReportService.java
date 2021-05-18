package com.coronaconsulatation.service;

import com.coronaconsulatation.entities.PatientReport;


public interface IPatientReportService {
	public boolean AddService(PatientReport patientreport);
	public PatientReport GetReport(int id);

}
