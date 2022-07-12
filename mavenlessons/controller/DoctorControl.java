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
import com.chainsys.mavenlessons.repository.DoctorRepository;
@RestController
public class DoctorControl {
		@Autowired
		private DoctorRepository repo;

//		@Bean
//		public void setRepo(DoctorRepository repo) {
//			this.repo = repo;
//		}
//		@GetMapping("/getDoctor")
//		//we need to give from where to read data from the HTTP request and also the content type application/json
//		public Doctor getDoctor(int id) {
//			return repo.findById(id);
//		}
		@GetMapping(value="/getdoctor")
		public String getDocor(int id) {
			return repo.findById(id).toString();
		}
		@GetMapping(value="/getdoctorappointments")
		public String getAppointments(int id) {
			Doctor doc = repo.findById(id);
			List<Appointments> appointments =doc.getAppointments();
			return appointments.toString();
		}

		@PostMapping(value ="/newDoctor",consumes ="application/json")
		public RedirectView addNewDoctor(@RequestBody Doctor dr) {
			System.out.println("Doctor :" + dr.getId()+" "+dr.getDoctor_name());
			repo.save(dr);
			return  new RedirectView("/getAllDoctor");
		}

		@DeleteMapping(value="/deleteDoctor")
		public RedirectView deleteDoctor(int id) {
			repo.deleteById(id);
			return  new RedirectView("/getAllDoctor");
		}
		@PostMapping(value ="/modifyDoctor",consumes ="application/json")
		public RedirectView modifyDoctor(@RequestBody Doctor dr) {
			//System.out.println("Doctor :" + Dr.getDoctor_id()+" "+Dr.getDotor_name());
			repo.save(dr);
			return  new RedirectView("/getAllDoctor");
		}

		@GetMapping(value="/getAllDoctor")
		public List<Doctor> getDoctor() {
			return repo.findAll();
		}

}
