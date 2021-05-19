package com.coronaconsulatation.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;



import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.coronaconsulatation.entities.Patient;
import com.coronaconsulatation.repository.PatientRepository;
import com.coronaconsulatation.service.IPatientService;
import com.coronaconsulatation.service.PatientServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(PatientController.class)
class PatientControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private PatientServiceImpl patientServiceImpl;
	
	
	@Test
	void createPatientTest() throws Exception {
		
		Patient patient = new Patient();
		patient.setName("Gowtham");
		patient.setEmail("GowthamMiriyala@gmail.com");
		
		Mockito.when(patientServiceImpl.createPatient(Mockito.any())).thenReturn(true);
		
		
		mockMvc.perform(post("/api/patient/")
						.contentType(MediaType.APPLICATION_JSON)
						.content(new ObjectMapper().writeValueAsString(patient))
						)
				.andExpect(MockMvcResultMatchers.status().isOk());		
	}
	@Test
	void findPatientTest() throws Exception {
		
		Patient patient = new Patient();
		patient.setName("Gowtham");
		patient.setLocation("Bhimavaram");
		patient.setMobile("123445");
		
		Mockito.when(patientServiceImpl.findById(Mockito.anyInt())).thenReturn(patient);
		
		mockMvc.perform(get("/api/patient/get/1"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Gowtham"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.location").value("Bhimavaram"));
				
	}
}
	
	
	
