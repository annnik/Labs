package controllers;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;

import com.lab.entities.Customers;
import com.lab.entities.Projects;
import com.lab.repositories.ProjectsRepository;


public class ProjectController {
	@Autowired
	private ProjectsRepository repository;
	
	public Projects project(Projects project) {
		return repository.save(project);
	}
/*
	public Projects add(Projects newCustomer) throws ValidationException {
		Projects customer = repository.findOne(newCustomer.getName());
		if (customer == null) {

			customer = new Customers(newCustomer.getName());
			customer.setName(newCustomer.getName());
			repository.save(customer);
		}
		return customer;
	}

	public void save(Customers customer) {
		this.repository.save(customer);
	}

	public Customers findCustomer(String name) {
		return repository.findOne(name);
	}

	public void remove(String name) {
		if (name != null) {
			this.repository.delete(name);
		}
	}

	public Iterable<Customers> findCustomers() {
		return repository.findAll();
	}*/
}
