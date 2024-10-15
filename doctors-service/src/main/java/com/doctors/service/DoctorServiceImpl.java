package com.doctors.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.doctors.bean.Patient;

public class DoctorServiceImpl implements DoctorService {

	@Autowired
	RestTemplate template;
	
	@Override
	public List<Patient> getPatientList(String name) {
		return (List<Patient>) template.getForEntity("https://localhost:2222/patient/{name}", List.class, name).getBody();
	}

}
