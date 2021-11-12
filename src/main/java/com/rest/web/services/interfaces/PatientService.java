package com.rest.web.services.interfaces;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.rest.web.services.model.Patient;

@Consumes("application/xml, application/json")
@Produces("application/json, application/xml")
@Path("/patientservice")
public interface PatientService {

	// getting list of patients
	@Path("/patients")
	@GET
	List<Patient> getPatients();

	// getting single patient
	@Path("/patients/{id}")
	@GET
	Patient getPatient(@PathParam(value = "id") Integer id);

	// Create a patient
	@Path("/patients")
	@POST
	Response createPatient(Patient patient);

	// updating patient. Patient will want to update name information.
	@Path("/patients")
	@PUT
	Response updatePatient(Patient patient);

	// delete a patient entry
	@Path("/patients/{id}")
	@DELETE
	Response deletePatient(@PathParam(value = "id") Integer id);
}
