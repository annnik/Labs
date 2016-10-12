package processors;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab.Utils;
import com.lab.entities.Projects;

import controllers.ProjectController;

@RestController
public class ProjectsProcessor {
	@Autowired
	ProjectController controller;
	
/*

	@RequestMapping(value = "/add")
	synchronized public ResponseEntity<Object> register(@RequestHeader("Authentication") byte[] authData,
			@RequestBody Map<String, String> request) {
		try {
			Projects newProject = Utils.parseAuthHeader(authData);
			newProject.setName(request.get("name"));
			return new ResponseEntity<Object>(controller.add(newProject), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping("/getProjects")
	synchronized public ResponseEntity<Object> getCustomers() {
		return new ResponseEntity<Object>(controller.findProjects(), HttpStatus.OK);
	}

	@RequestMapping("/updateProject")
	public ResponseEntity<Object> updateCustomer(@RequestBody Map<String, String> request) {
		Projects project = controller.findProject(request.get("name"));
		if (project != null) {
			project.setName(request.get("name"));
			controller.save(project);
			return new ResponseEntity<Object>(HttpStatus.OK);
		}
		return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping("/removeProject")
	synchronized public ResponseEntity<Object> removeCustomer(@RequestBody Map<String, String> request) {
		controller.remove(request.get("name"));
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
*/
}
