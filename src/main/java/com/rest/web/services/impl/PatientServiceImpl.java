package com.rest.web.services.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.rest.web.services.interfaces.PatientService;
import com.rest.web.services.model.Patient;

@Service
public class PatientServiceImpl implements PatientService {

	Map<Integer, Patient> map = new HashMap<>();
	int patientId = 1;

	public PatientServiceImpl() {
		init();
	}

	private void init() {

		Patient patient = new Patient();
		patient.setId(patientId);
		patient.setName("Alexa");
		map.put(patient.getId(), patient);
	}

	@Override
	public List<Patient> getPatients() {

		Collection<Patient> results = map.values();
		List<Patient> response = new ArrayList<>(results);
		return response;
	}

	@Override
	public Patient getPatient(Integer id) {
		Patient patient = map.get(id);
		return patient;
		// or simple use return map.get(id);
	}

	@Override
	public Response createPatient(Patient patient) {
		patient.setId(++patientId);
		map.put(patient.getId(), patient);
		return Response.ok(patient).build();
	}

	@Override
	public Response updatePatient(Patient patient) {
		Patient currentPatient = map.get(patient.getId());
		Response response;
		if (currentPatient != null) {
			map.put(patient.getId(), patient);
			response = Response.ok().build();
		} else {
			response = Response.notModified().build();
		}
		return response;
	}

	@Override
	public Response deletePatient(Integer id) {

		Patient patient = map.get(id);
		Response response;
		if (patient != null) {
			map.remove(id);
			response = Response.ok().build();
		} else {
			response = Response.notModified().build();
		}
		return response;
	}

}
