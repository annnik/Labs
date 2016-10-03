package com.lab.entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
	import javax.persistence.Table;
	@Entity
	@Table(name = "Customers")
public class Customers {
		@Id
		@GeneratedValue
		private int Customers_id;		
		private String name;	
		public Customers() {

		}

		public Customers(String name) {
			super();
			this.name = name;
		}

		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		
}
