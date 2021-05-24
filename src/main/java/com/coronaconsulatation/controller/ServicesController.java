package com.coronaconsulatation.controller;

import java.util.List;

import javax.annotation.security.PermitAll;

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

import com.coronaconsulatation.entities.Patient;
import com.coronaconsulatation.entities.ServiceType;
import com.coronaconsulatation.entities.Services;
import com.coronaconsulatation.service.ServiceMasterImpl;



@RestController
@RequestMapping("/api/services/")
public class ServicesController {
	@Autowired
	ServiceMasterImpl serviceMasterImpl;
	
	@PostMapping("/")
	public ResponseEntity<String> createService(@RequestBody Services service){
		serviceMasterImpl.createService(service);
		return new ResponseEntity<>("Service Created!!",HttpStatus.OK);
		
	}
	
	@PutMapping("/updateService/updateAllFields/{id}/")
	public ResponseEntity<String> updateService(@PathVariable int serviceid, @RequestBody Services service){
		if(serviceMasterImpl.updateService(serviceid, service)) {
			return new ResponseEntity<>("Service Updated!!", HttpStatus.OK);
		}
		return new ResponseEntity<>("No such id Exists!!", HttpStatus.NOT_FOUND);
	}
	
	
	@PutMapping("/updateService/updateServiceName/{id}/")
	public ResponseEntity<String> updateAdditionalServiceName(@PathVariable int serviceid, @RequestBody String additionalServiceName){
		if(serviceMasterImpl.updateAdditionalServiceName(serviceid, additionalServiceName)) {
			return new ResponseEntity<>("AdditionalServiceName Updated!!", HttpStatus.OK);
		}
		return new ResponseEntity<>("No such id Exists!!", HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/{id}/")
	public ResponseEntity<String> deleteService(@PathVariable int serviceid){
		if(serviceMasterImpl.deleteService(serviceid)) {
			return new ResponseEntity<String>("Services deleted !!", HttpStatus.OK);
		}
		return new ResponseEntity<>("No such id Exists!!", HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/{id}/")
	public ResponseEntity<Services> getService(@PathVariable("serviceid") int serviceid){
		Services ser =serviceMasterImpl.getService(serviceid);
		if(ser!=null) {
			return new ResponseEntity<>(ser, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/allServices")
	public ResponseEntity<List<Services>> getAllServices(){
		List<Services> ser = serviceMasterImpl.getAllServices();
		if(ser!=null) {
			return new ResponseEntity<>(ser, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
}
