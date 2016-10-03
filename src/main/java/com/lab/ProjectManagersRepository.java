package com.lab;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.*;

import com.lab.entities.ProjectManagers;

public interface ProjectManagersRepository extends CrudRepository<ProjectManagers, String>{
	@Query("SELECT u FROM ProjectManagers")
	List<ProjectManagers> findAllProjects();
}
