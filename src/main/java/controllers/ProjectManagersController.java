package controllers;

import org.springframework.beans.factory.annotation.Autowired;

import com.lab.entities.ProjectManagers;
import com.lab.repositories.ProjectManagersRepository;

public class ProjectManagersController {
	@Autowired
	private ProjectManagersRepository repository;
	
	public ProjectManagers project(ProjectManagers pm) {
		return repository.save(pm);
	}
}
