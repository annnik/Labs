	package com.lab.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
	@Entity
	@Table(name = "Project_Payments")

public class ProjectPayment {

	@Id
	@GeneratedValue
	private int ID_Project_payments;
	
	private long date;		
	private int sum;
	@ManyToOne
	private Projects Projects_id;
	public ProjectPayment() {

	}

	public ProjectPayment(long date, int sum, Projects Projects_id) {
		super();
		this.date = date;
		this.sum = sum;
		this.Projects_id = Projects_id;
	}

	
	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public Projects getProjects_id() {
		return Projects_id;
	}

	public ProjectPayment setProjects_id(Projects Projects_id) {
		this.Projects_id = Projects_id;
		return this;
	}

	

}
