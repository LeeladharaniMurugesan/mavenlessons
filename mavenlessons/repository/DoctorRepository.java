package com.chainsys.mavenlessons.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.chainsys.mavenlessons.entity.Doctor;

public interface DoctorRepository extends CrudRepository<Doctor, Integer> {
	Doctor findById(int id);// Query will generates here

	Doctor save(Doctor Dr);

	// used for adding new doctor and modifying the doctor
	void deleteById(int id);

	List<Doctor> findAll();

}
