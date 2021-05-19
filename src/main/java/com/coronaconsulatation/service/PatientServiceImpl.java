package com.coronaconsulatation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.coronaconsulatation.Exception.IdNotFoundException;
import com.coronaconsulatation.Exception.PatientException;
import com.coronaconsulatation.entities.Patient;
import com.coronaconsulatation.entities.ServiceType;
import com.coronaconsulatation.entities.Services;
import com.coronaconsulatation.repository.PatientRepository;
import com.coronaconsulatation.repository.ServiceRepository;


@Service
public class PatientServiceImpl implements IPatientService{
	
	@Autowired
	private PatientRepository patientrepository;
	
	@Override
	public boolean createPatient(Patient patient) {
		// TODO Auto-generated method stub
		if(patient.getName()==null || patient.getEmail()==null){
			throw new PatientException("Given Patient Object is Null");
		}
		if(patient!=null)
		{
			patientrepository.save(patient);
			return true;
		}
		return false;
	}

	@Override
	public boolean updatePatient(int id,Patient patient) {
		Patient pat = patientrepository.findById(id).get();

		if(pat==null) {
			throw new IdNotFoundException("Given Id is Not found, Please Enter valid Id");
			
		}
		else if (pat!=null) {
			
			patientrepository.save(pat);
			return true;
			
		}

		
		return false;
	}


	@Override
	public boolean deletePatient(int id) {
		
		Optional<Patient> obj=	patientrepository.findById(id);	
		Patient pat;
		if(obj.isPresent()) 
		{
			pat=obj.get();
		}
		else 
		{
			throw new IdNotFoundException("Given Id is Not found, Please Enter valid Id");
		}
		
		
		if(pat!=null) {
			patientrepository.deleteById(id);;
			return true;
		}
		return false;
	}

	@Override
	public Patient findById(int id) {
		Patient pat= patientrepository.findById(id).get();
		if(pat==null) {
			throw new IdNotFoundException("Given Id is Not found, please Enter valid Id");
		}
		
		else if(pat!=null) {
			return pat;
		}
		return null;
		
	}

	@Override
	public List<Patient> getAllPatients() {
		   List<Patient> patient= patientrepository.findAll();
		   if(patient!=null) {
			   return patient;
		   }
		return null;
	}

	@Override
	public boolean updateName(int id, String name) {
		Patient pat = patientrepository.findById(id).get();
		
		if(pat==null) {
			throw new IdNotFoundException("Given Id is Not found, please Enter valid Id");
		}

		else if (pat!=null) {
			pat.setName(name);

			patientrepository.save(pat);
			return true;
		}
		return false;
	}


	@Override
	public boolean updateLocation(int id, String location) {
		Patient pat = patientrepository.findById(id).get();
		
		if(pat==null) {
			throw new IdNotFoundException("Given Id is Not found, please Enter valid Id");
		}

		else if (pat!=null) {
			pat.setLocation(location);

			patientrepository.save(pat);
			return true;
		}
		return false;
	}

	@Override
	public boolean updateEmail(int id, String email) {
		Patient pat = patientrepository.findById(id).get();

		if(pat==null) {
			throw new IdNotFoundException("Given Id is Not found, please Enter valid Id");
		}

		if (pat!=null) {
			pat.setEmail(email);
			patientrepository.save(pat);
			return true;
		}
		
		
		return false;
	}

	@Override
	public boolean updateMobile(int id, String mobile) {
		Patient pat = patientrepository.findById(id).get();

		if(pat==null) {
			throw new IdNotFoundException("Given Id is Not found, please Enter valid Id");
		}

		if (pat!=null) {
			pat.setMobile(mobile);

			patientrepository.save(pat);
			return true;
		}
		
		
		return false;
	}

	}


