package processors;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab.Utils;
import com.lab.entities.Customers;

import controllers.CustomersController;

@RestController
public class CustomersProcessor {

	@Autowired
	CustomersController controller;

	@RequestMapping(value = "/add")
	synchronized public ResponseEntity<Object> register(@RequestHeader("Authentication") byte[] authData,
			@RequestBody Map<String, String> request) {
		try {
			Customers newCustomer = Utils.parseAuthHeader(authData);
			newCustomer.setName(request.get("name"));
			return new ResponseEntity<Object>(controller.add(newCustomer), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping("/getCustomers")
	synchronized public ResponseEntity<Object> getCustomers() {
		return new ResponseEntity<Object>(controller.findCustomers(), HttpStatus.OK);
	}

	@RequestMapping("/updateCustomer")
	public ResponseEntity<Object> updateCustomer(@RequestBody Map<String, String> request) {
		Customers customer = controller.findCustomer(request.get("name"));
		if (customer != null) {
			customer.setName(request.get("name"));
			controller.save(customer);
			return new ResponseEntity<Object>(HttpStatus.OK);
		}
		return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping("/removeCustomer")
	synchronized public ResponseEntity<Object> removeCustomer(@RequestBody Map<String, String> request) {
		controller.remove(request.get("name"));
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	
}
