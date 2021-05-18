package com.coronaconsulatation.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.coronaconsulatation.Exception.IdNotFoundException;
import com.coronaconsulatation.Exception.PatientException;
import com.coronaconsulatation.entities.Patient;



public interface IPatientService {
	
	public boolean createPatient(Patient patient);
	public boolean updatePatient(int id,Patient patient);
	public boolean deletePatient(int id);
	public Patient getPatient(int id);
	public List<Patient> getAllPatients();
	public boolean updateName(int id,String name);
	public boolean updateMobile(int id,String Mobile);
	public boolean updateEmail(int id,String email);
	public boolean updateLocation(int id,String location);

}