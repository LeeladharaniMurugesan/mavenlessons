package com.chainsys.mavenlessons.entity;

import java.util.Date;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Doctor")
public class Doctor {
	@Id
	@Column(name = "DOCTOR_ID")
	private int id;
	private String doctor_name;
	private Date dob;
	private String speciality;
	private String city;
	private long phoneno;
	@Column(name = "standard_fees")
	private float standard_fees;

	// Bidirectional Association
	//each doctor can have one or more appointments so the list is used
	@OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Appointments> appointments;

	public List<Appointments> getAppointments() {
		return this.appointments;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDoctor_name() {
		return doctor_name;
	}

	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(long phoneno) {
		this.phoneno = phoneno;
	}

	public float getStandard_fees() {
		return standard_fees;
	}

	public void setStandard_fees(float standard_fees) {
		this.standard_fees = standard_fees;
	}

	public void setAppointments(List<Appointments> appointments) {
		this.appointments = appointments;
	}

	@Override
	public String toString() {
		return String.format("%d,%s,%s,%s,%s,%s,%.2f", id, doctor_name, dob, speciality, city, phoneno, standard_fees);

	}
}
