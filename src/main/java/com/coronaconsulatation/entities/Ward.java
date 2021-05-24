package com.coronaconsulatation.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GeneratorType;

import lombok.Data;

@Entity
@Data
public class Ward {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer W_id;
	private String Ward_name;
	private String Ward_type;

}
