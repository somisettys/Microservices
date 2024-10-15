package com.doctors.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.doctors.bean.Patient;

@Service
public interface DoctorService {
	public List<Patient> getPatientList(String name);
}
