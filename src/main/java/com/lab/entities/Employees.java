
package com.lab.entities;	
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
	@Entity
	@Table(name = "Employees")


public class Employees {

		@Id
		@GeneratedValue
		private int Employees_id;
		
		private String name;		
		private String job;
		@ManyToMany
		private List<Projects> projects;
		
		public Employees() {

		}

		public Employees(String name, String job, List <Projects>projects) {
			super();
			
			this.job = job;
			this.name = name;
			this.projects=projects;
		}

		public List<Projects> getProjects() {
			return projects;
		}

		public Employees setProjects(List<Projects> projects) {
			this.projects = projects;
			return this;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getjob() {
			return job;
		}

		public void setjob(String job) {
			this.job = job;
		}

		
		
	
}
