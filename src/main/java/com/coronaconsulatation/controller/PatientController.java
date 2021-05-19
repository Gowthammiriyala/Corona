package com.coronaconsulatation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import com.coronaconsulatation.Exception.PatientException;
import com.coronaconsulatation.entities.Patient;
import com.coronaconsulatation.entities.ServiceType;
import com.coronaconsulatation.entities.Services;
import com.coronaconsulatation.service.PatientServiceImpl;

@RestController
@RequestMapping("/api/patient")
public class PatientController {
	
	@Autowired
	private PatientServiceImpl patientserviceimpl;
	
	@PostMapping("/")
	public ResponseEntity<String> createPatient(@RequestBody Patient patient){
		
		patientserviceimpl.createPatient(patient);
		return new ResponseEntity<>("Patient Created!!",HttpStatus.OK);
		}
	
	@PutMapping("/updatePatient/updateAllFields/{id}/")
	public ResponseEntity<String> updatePatient(@PathVariable int patientid, @RequestBody Patient patient){
		if(patientserviceimpl.updatePatient(patientid, patient)) {
			return new ResponseEntity<>("Patient Updated!!", HttpStatus.OK);
		}
		return new ResponseEntity<>("No such id Exists!!", HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/updatePatient/updateName/{id}/")
	public ResponseEntity<String> updatePatientName(@PathVariable int patientid, @RequestBody String name){
		if(patientserviceimpl.updateName(patientid, name)) {
			return new ResponseEntity<>("Name Updated!!", HttpStatus.OK);
		}
		return new ResponseEntity<>("No such id Exists!!", HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/updatePatient/updateEmail/{id}/")
	public ResponseEntity<String> updatePatientEmail(@PathVariable int patientid, @RequestBody String email){
		if(patientserviceimpl.updateEmail(patientid, email)) {
			return new ResponseEntity<>("Email Updated!!", HttpStatus.OK);
		}
		return new ResponseEntity<>("No such id Exists!!", HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/updatePatient/updateMobile/{id}/")
	public ResponseEntity<String> updatePatientMobile(@PathVariable int patientid, @RequestBody String mobile){
		if(patientserviceimpl.updateMobile(patientid, mobile)) {
			return new ResponseEntity<>("Mobile Updated!!", HttpStatus.OK);
		}
		return new ResponseEntity<>("No such id Exists!!", HttpStatus.NOT_FOUND);
	}
	
	
	@PutMapping("/updatePatient/updateLocation/{id}/")
	public ResponseEntity<String> updateDoctorLocation(@PathVariable int patientid, @RequestBody String location){
		if(patientserviceimpl.updateLocation(patientid, location)) {
			return new ResponseEntity<>("Location Updated!!", HttpStatus.OK);
		}
		return new ResponseEntity<>("No such id Exists!!", HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deletePatient(@PathVariable("id") int patientid){
		if(patientserviceimpl.deletePatient(patientid)) {
			return new ResponseEntity<String>("Patient deleted !!", HttpStatus.OK);
		}
		return new ResponseEntity<>("No such id Exists!!", HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getPatient(@PathVariable("id") int patientid){
		Patient pat =patientserviceimpl.findById(patientid);
		if(pat==null) {
			return new ResponseEntity<String>("Patient Not Found", HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Patient>(pat, HttpStatus.OK);
	}
	
	@GetMapping("/allPatients")
	public ResponseEntity<List<Patient>> getAllPatients(){
		List<Patient> pat = patientserviceimpl.getAllPatients();
		if(pat!=null) {
			return new ResponseEntity<>(pat, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	

}