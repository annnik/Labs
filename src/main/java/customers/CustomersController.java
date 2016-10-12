package customers;
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

/*import com.mkyong.form.model.User;
import com.mkyong.form.service.UserService;
import com.mkyong.form.validator.UserFormValidator;*/

@Controller
public class CustomersController {
	@Autowired
	private CustomersRepository repository;
	@Autowired
	private CustomersService customerService;
	public Customers customer(Customers customer) {
		return repository.save(customer);
	}
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 3a11cea4559b9fc95df07a406080441ec6202078
	@RequestMapping(value = "/customers/add", method = RequestMethod.GET)
	public void addUser(Model mode){
		Customers customer = new Customers();
		// set default value
		customer.setName("Ann Nik");
		repository.save(customer);
		
	}
<<<<<<< HEAD
=======
	
>>>>>>> 456ebe1011f8579e1233a815c152d0a39a670148
=======
>>>>>>> 3a11cea4559b9fc95df07a406080441ec6202078

	@RequestMapping(value = "/customers", method = RequestMethod.POST)
	public String saveOrUpdate(@ModelAttribute("userForm") @Validated Customers customer,
			BindingResult result, Model model) {

	

		customerService.saveOrUpdate(customer);

			// POST/REDIRECT/GET
			return "redirect:/customers/" + customer.getId();

			// POST/FORWARD/GET
			// return "user/list";

		}
	
	@RequestMapping(value = "/customers/add", method = RequestMethod.GET)
	public String showAddUserForm(Model model) {

		Customers customer = new Customers();
		// set default value
		customer.setName("Ann Nik");
		
		return "customers/userform";

	}
}
