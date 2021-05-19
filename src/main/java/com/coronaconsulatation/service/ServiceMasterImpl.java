package com.coronaconsulatation.service;

import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coronaconsulatation.Exception.IdNotFoundException;
import com.coronaconsulatation.Exception.PatientException;
import com.coronaconsulatation.entities.Services;
import com.coronaconsulatation.repository.ServiceRepository;

@Service
public class ServiceMasterImpl implements IServiceMaster{
	
	@Autowired
	private ServiceRepository serviceRepository;

	@Override
	public boolean createService(Services service) {
		if(service.getAdditionalServices()==null){
			throw new ServiceException("Given Service Object is Null");
		}
		if(service!=null)
		{
			serviceRepository.save(service);
			return true;
		}
		return false;
	}

	@Override
	public boolean updateService(int serviceid,Services service) {
		Services ser = serviceRepository.findById(serviceid).get();
		if(ser==null) {
			throw new IdNotFoundException("Given Id is Not found, Please Enter valid Id");
		}
		else if (ser!=null) {
			serviceRepository.save(ser);
			return true;	
		}
		return false;
	}

	@Override
	public boolean deleteService(int serviceid) {
		
		Services ser =serviceRepository.findById(serviceid).get();
		if(ser==null) {
			throw new IdNotFoundException("Given Id is Not found, Please Enter valid Id");
		}
		else if(ser!=null) {
			serviceRepository.deleteById(serviceid);;
			return true;
		}
		return false;
	}

	@Override
	public Services getService(int serviceid) {
		Services ser= serviceRepository.findById(serviceid).get();
		if(ser==null) {
			throw new IdNotFoundException("Given Id is Not found, Please Enter valid Id");
		}
		else if(ser!=null) {
			return ser;
		}
		return null;
	}

	@Override
	public List<Services> getAllServices() {
		// TODO Auto-generated method stub
		   List<Services> service= serviceRepository.findAll();
		   if(service!=null) {
			   return service;
		   }
		return null;
	}

	@Override
	public boolean updateAdditionalServiceName(int serviceid, String additionalServiceName) {
		Services ser = serviceRepository.findById(serviceid).get();
		if(ser==null) {
			throw new IdNotFoundException("Given Id is Not found, Please Enter valid Id");
		}

		else if (ser!=null) {
			ser.setAdditionalServices(additionalServiceName);

			serviceRepository.save(ser);
			return true;
		}
		return false;
	}

	
}