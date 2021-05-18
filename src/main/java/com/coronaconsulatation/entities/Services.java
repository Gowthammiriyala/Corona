package com.coronaconsulatation.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;



import lombok.Data;

@Entity
 @Data
public class Services {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int serviceid;
	private Boolean IPD;
	private Boolean OPD;
	private String additionalServices;

}
