package com.chainsys.mavenlessons.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Appointments")
public class Appointments {
	@Id
	@Column(name = "app_id")
	private int app_id;
	@Column(name = "app_date")
	private Date app_date;
	@Column(name = "doctor_id")
	private int doctor_id;
	@Column(name = "patient_name")
	private String patient_name;
	@Column(name = "fees_collected")
	private float fees_collected;
	//for many instances of appointment object only one instance of doctor object
	//@Joincolumn maps the column(Doc_Id) of  the current Entity Appointment
	//with the primary key column(id) of the associated Entity Doctor 
	@ManyToOne(fetch =FetchType.LAZY)
	@JoinColumn(name="DOCTOR_ID",nullable=false,insertable=false,updatable=false)
	@JsonIgnore
	private Doctor doctor;
	
		public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

		public int getApp_id() {
		return app_id;
	}

	public void setApp_id(int app_id) {
		this.app_id = app_id;
	}

	public Date getApp_date() {
		return app_date;
	}

	public void setApp_date(Date app_date) {
		this.app_date = app_date;
	}

	public int getDoctor_id() {
	return doctor_id;
	}

	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}

	public String getPatient_name() {
		return patient_name;
	}

	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}

	public float getFees_collected() {
		return fees_collected;
	}

	public void setFees_collected(float fees_collected) {
		this.fees_collected = fees_collected;
	}
	@Override
	public String toString() {
		return String.format("%d,%s,%s,%s,%.2f",app_id,app_date,doctor_id,patient_name,fees_collected);

}

}
