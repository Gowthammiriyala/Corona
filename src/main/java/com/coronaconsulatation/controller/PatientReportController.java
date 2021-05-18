package com.coronaconsulatation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coronaconsulatation.entities.PatientReport;
import com.coronaconsulatation.entities.ServiceType;
import com.coronaconsulatation.entities.Services;
import com.coronaconsulatation.service.PatientReportServiceImpl;

@RestController
@RequestMapping("api/patientReport")
public class PatientReportController {
	
	@Autowired
	private PatientReportServiceImpl patientreportserviceimpl;
	
	@PostMapping("/")
	public ResponseEntity<String> AddNewServices(@RequestBody PatientReport patientreport){
		if(patientreport.getCondition()) {
			patientreport.setServicetype(ServiceType.IPD);
		}
		else {
			patientreportserviceimpl.setServicetype(ServiceType.OPD);
		}
		patientreportserviceimpl.AddService(patientreport);
		return new ResponseEntity<>("PatientReport Added",HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}/")
	public ResponseEntity<Services> GetReportData(@RequestBody int id){
		PatientReport pr= patientreportserviceimpl.GetReport(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
