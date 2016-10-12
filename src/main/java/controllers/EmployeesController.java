package controllers;

import org.springframework.beans.factory.annotation.Autowired;

import com.lab.entities.Employees;
import com.lab.repositories.EmployeesRepository;

public class EmployeesController {
	@Autowired
	private EmployeesRepository repository;
	
	public Employees project(Employees employee) {
		return repository.save(employee);
	}
}
