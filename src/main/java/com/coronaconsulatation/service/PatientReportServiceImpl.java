package com.coronaconsulatation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coronaconsulatation.Exception.PatientException;
import com.coronaconsulatation.entities.PatientReport;
import com.coronaconsulatation.entities.ServiceType;
import com.coronaconsulatation.repository.PatientReportRepository;

@Service
public class PatientReportServiceImpl implements IPatientReportService {
	
	@Autowired
	private PatientReportRepository patientreportrepository;


	@Override
	public boolean AddService(PatientReport patientreport) {
		patientreportrepository.save(patientreport);
		return true;
	}

	@Override
	public PatientReport GetReport(int id) {
		if(!patientreportrepository.existsById(id)) {
			throw new  PatientException("Id Not Found");
		}
		
		PatientReport pr =  patientreportrepository.findById(id).get();
		return pr;
		
	}

	public void setServicetype(ServiceType opd) {
		// TODO Auto-generated method stub
		
	}

	
}
