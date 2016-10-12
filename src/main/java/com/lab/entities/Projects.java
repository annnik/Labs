package com.lab.entities;	
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
	@Entity
	@Table(name = "Projects")
public class Projects {

		@Id
		@GeneratedValue
		private int Projects_id;
			
		private String name;
		@ManyToOne
		private Customers Customers_id;
		@ManyToOne
		private ProjectManagers Project_managers_id;
		public Projects() {

		}

		/*public Projects(String name, Customers  Customers_id, ProjectManagers Project_managers_id) {
			super();
			
			this.Customers_id = Customers_id;
			this.name = name;
			this.Project_managers_id = Project_managers_id;
		}

		*/
		public Customers getCustomers_id() {
			return Customers_id;
		}

		public Projects setCustomers_id(Customers Customers_id) {
			this.Customers_id = Customers_id;
			return this;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public ProjectManagers  getProject_managers_id() {
			return Project_managers_id;
		}

		public Projects setProject_managers_id(ProjectManagers  Project_managers_id) {
			this.Project_managers_id = Project_managers_id;
			return this;
		}

		

		
		
		

}
