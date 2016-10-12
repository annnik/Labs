package controllers;

import org.springframework.beans.factory.annotation.Autowired;

import com.lab.entities.ProjectPayment;
import com.lab.repositories.ProjectPaymentRepository;

public class ProjectPaymentController {
	@Autowired
	private ProjectPaymentRepository repository;
	
	public ProjectPayment project(ProjectPayment projectpayment) {
		return repository.save(projectpayment);
	}
}
