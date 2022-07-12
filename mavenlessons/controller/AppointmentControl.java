package com.chainsys.mavenlessons.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.chainsys.mavenlessons.entity.Appointments;
import com.chainsys.mavenlessons.entity.Doctor;
import com.chainsys.mavenlessons.repository.AppointmentRepository;

@RestController
public class AppointmentControl {
	@Autowired
	private AppointmentRepository repo;

	@GetMapping(value = "/getdoctorbyappointmentid")
	public String getDoctorByAppointmentId(int id) {
		Appointments app = repo.findById(id);
		Doctor doc = app.getDoctor();
		return doc.toString();
	}

	@GetMapping(value = "/getappointment")
	public Appointments getAppointmentById(int id) {
		return repo.findById(id);
	}

//	@GetMapping(value = "/getappointmentbydoctor")
//	public List<Appointments> getAppointmentByDocId(int id) {
//		return repo.findAllByDoctorId(id);
//	}
	@GetMapping(value = "/getallappointments")
	public List<Appointments> getAllAppointments() {
		return repo.findAll();
	}

	@PostMapping(value = "/newappointment", consumes = "application/json")
	public RedirectView addAppointment(@RequestBody Appointments apt) {
		repo.save(apt);
		return new RedirectView("/getallappointments");
	}

	@PostMapping(value = "/modifyappointment", consumes = "application/json")
	public RedirectView updateAppointment(@RequestBody Appointments apt) {
		repo.save(apt);
		return new RedirectView("/getallappointments");
	}

	@DeleteMapping(value = "/removeappointment")
	public RedirectView deleteAppointment(int id) {
		repo.deleteById(id);
		return new RedirectView("/getallappointments");
	}
}
