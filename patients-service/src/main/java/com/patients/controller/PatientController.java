package com.patients.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.patients.bean.Patient;

@RestController
public class PatientController {
	
	@GetMapping("/patient/{name}")
	public List<Patient> getPatient(@PathVariable String name){
		return getPatientList().entrySet().stream().filter(e -> e.getValue().contains(name))
				.map(e -> e.getValue()).findAny().orElse(null);
	}
	
	private Map<String, List<Patient>> getPatientList(){
		List<Patient> aPatientsList = new ArrayList<>();
		aPatientsList.add(new Patient("P1"));
		aPatientsList.add(new Patient("P2"));
		List<Patient> bPatientsList = new ArrayList<>();
		bPatientsList.add(new Patient("P3"));
		bPatientsList.add(new Patient("P4"));
		List<Patient> cPatientsList = new ArrayList<>();
		cPatientsList.add(new Patient("P5"));
		cPatientsList.add(new Patient("P6"));
		Map<String, List<Patient>> docMap = new HashMap<>();
		docMap.put("A", aPatientsList);
		docMap.put("B", bPatientsList);
		docMap.put("C", cPatientsList);
		docMap.put("D", new ArrayList<>());
		return docMap;
	}
}
