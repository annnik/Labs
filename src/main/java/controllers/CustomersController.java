package controllers;

import javax.validation.ValidationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.beans.factory.annotation.Autowired;

import com.lab.entities.Customers;
import com.lab.repositories.CustomersRepository;

import customers.CustomersService;

/*import com.mkyong.form.model.User;
import com.mkyong.form.service.UserService;
import com.mkyong.form.validator.UserFormValidator;*/

@Controller
public class CustomersController {
	@Autowired
	private CustomersRepository repository;

	public Customers customer(Customers customer) {
		return repository.save(customer);
	}

	public Customers add(Customers newCustomer) throws ValidationException {
		Customers customer = repository.findOne(newCustomer.getName());
		if (customer == null) {

			customer = new Customers();
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
	}



	/*
	 * @RequestMapping(value = "/customers/add", method = RequestMethod.GET)
	 * public void addUser(Model mode){ Customers customer = new Customers(); //
	 * set default value customer.setName("Ann Nik"); repository.save(customer);
	 * 
	 * }
	 * 
	 * @RequestMapping(value = "/customers", method = RequestMethod.POST) public
	 * String saveOrUpdate(@ModelAttribute("userForm") @Validated Customers
	 * customer, BindingResult result, Model model) {
	 * 
	 * 
	 * 
	 * customerService.saveOrUpdate(customer);
	 * 
	 * // POST/REDIRECT/GET return "redirect:/customers/" + customer.getId();
	 * 
	 * // POST/FORWARD/GET // return "user/list";
	 * 
	 * }
	 * 
	 * @RequestMapping(value = "/customers/add", method = RequestMethod.GET)
	 * public String showAddUserForm(Model model) {
	 * 
	 * Customers customer = new Customers(); // set default value
	 * customer.setName("Ann Nik");
	 * 
	 * return "customers/userform";
	 * 
	 * }
	 */
}
