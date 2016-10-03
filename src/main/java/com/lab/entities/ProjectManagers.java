package com.lab.entities;
	import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
	import javax.persistence.Table;
	@Entity
	@Table(name = "Project_managers")


public class ProjectManagers {
	
	

		@Id
		@GeneratedValue
		private int Project_managers_id;
		
		private String name;		
		private String department;
		private int salary;
		public ProjectManagers() {

		}

		public ProjectManagers(String name, String department, int salary) {
			super();
			
			this.department = department;
			this.name = name;
			this.salary = salary;
		}

		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDepartment() {
			return department;
		}

		public void setDepartment(String department) {
			this.department = department;
		}

		public int getSalary() {
			return salary;
		}

		public void setSalary(int salary) {
			this.salary = salary;
		}

		
	
}
