package com.coronaconsulatation.service;


import java.util.List;

import com.coronaconsulatation.Exception.IdNotFoundException;
import com.coronaconsulatation.entities.Patient;
import com.coronaconsulatation.entities.Services;

public interface IServiceMaster {
	public boolean createService(Services services);
	public boolean updateService(int serviceid,Services services);
	public boolean deleteService(int id);
	public Services getService(int id);
	public List<Services> getAllServices();
	public boolean updateAdditionalServiceName(int id,String additionalServiceName);
}