package com.doctors.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.doctors.bean.Doctors;
import com.doctors.bean.Patient;
import com.doctors.service.DoctorService;

@RestController
public class DoctorController {
	
	@Autowired
	DoctorService docService;

	@GetMapping("/doctor/{name}")
	public List<Patient> getDoctor(@PathVariable String name){
		String docName =  getDoctorsList().stream()
				.filter(doctor -> doctor.getName().equalsIgnoreCase(name))
				.findFirst().orElse(null).getName();
		return docService.getPatientList(docName);
	}
	
	@GetMapping
	public List<Doctors> getDoctors(){
		return getDoctorsList();
	}
	
	
	private List<Doctors> getDoctorsList(){
		List<Doctors> doctorsList = new ArrayList<>();
		doctorsList.add(new Doctors("A"));
		doctorsList.add(new Doctors("B"));
		doctorsList.add(new Doctors("C"));
		doctorsList.add(new Doctors("D"));
		doctorsList.add(new Doctors("E"));
		doctorsList.add(new Doctors("F"));
		return doctorsList;
	}
}
