package com.chainsys.mavenlessons.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.chainsys.mavenlessons.entity.Appointments;

public interface AppointmentRepository extends CrudRepository<Appointments, Integer> {
	Appointments findById(int id);
	Appointments save(Appointments app);
	void deleteById(int id);
	List<Appointments> findAll();
//	@Query(value ="select a from Appointments a where a.doctor_id=?1")//?1 denotes first parameters
	//jpql - java persistent query language
	//here a is an instance of Appointments Entity
//	List<Appointments> findAllByDoctorId(int drid);
	List<Appointments> findByDoctorId(int id);
	
	
	
}
