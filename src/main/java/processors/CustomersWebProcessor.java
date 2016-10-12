package processors;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lab.entities.Customers;
import com.lab.repositories.CustomersRepository;

@RestController("/webapps")
public class CustomersWebProcessor {
	@Autowired
	CustomersRepository customerRepository;

	@RequestMapping(value = "/webapps/pages/get_customer")
	public Customers getCustomer(@RequestParam("id") String id) {
		return customerRepository.findOne(id);
	}

	@RequestMapping(value = "/webapps/pages/get_customers")
	public List<CustomersWeb> getUsers() {
		List<CustomersWeb> result = new ArrayList<CustomersWeb>();
		for (Customers customer : customerRepository.findAll()) {
			result.add(new CustomersWeb(customer.getName()));
		}
		return result;
	}

	@RequestMapping(value = "/webapps/pages/add")
	public void register(@RequestParam("name") String name) {
		Customers result = new Customers();
		result.setName(name);
		customerRepository.save(result);
	}

	@RequestMapping(value = "/webapps/pages/remove")
	public void remove(@RequestParam("id") String login) {
		customerRepository.delete(login);
	}

	@RequestMapping("/webapps/pages/{url:.*}")
	public String loadPage(HttpServletRequest request) {
		return load(request);
	}

	@RequestMapping("/webapps/pages/js/{url:.*}")
	public String loadScript(HttpServletRequest request) {
		return load(request);
	}

	private String load(HttpServletRequest request) {
		BufferedReader reader = null;
		try {
			StringBuilder pageBuilder = new StringBuilder();
			String url = request.getRequestURI();
			reader = new BufferedReader(new FileReader(url.toString().substring(1, url.length())));
			String line = null;
			while ((line = reader.readLine()) != null) {
				pageBuilder.append(line).append("\n");
			}
			return pageBuilder.toString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	private static final class CustomersWeb {
		
		private String name;

		public CustomersWeb( String name) {
		
			this.name = name;
		}

		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
}
