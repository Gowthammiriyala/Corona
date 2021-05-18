package com.coronaconsulatation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.coronaconsulatation.entities.Services;

public interface ServiceRepository extends JpaRepository<Services, Integer>{
	
}
