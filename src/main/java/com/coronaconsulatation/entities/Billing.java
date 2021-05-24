package com.coronaconsulatation.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Billing {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer B_id;
	private String Patient_name;
	private String Patient_location;
	

}
