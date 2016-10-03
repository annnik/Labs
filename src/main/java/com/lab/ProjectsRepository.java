package com.lab;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.*;

import com.lab.entities.Projects;

public interface ProjectsRepository extends CrudRepository<Projects, String>{
	@Query("SELECT u FROM Projects")
	List<Projects> findAllProjects();
}
