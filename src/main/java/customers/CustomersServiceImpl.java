package customers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.lab.entities.Customers;
public class CustomersServiceImpl  implements CustomersService {

	CustomersOperations cOp;

	@Autowired
	public void setCustomersOperations(CustomersOperations cOp) {
		this.cOp = cOp;
	}

/*	@Override
	public Customers findById(Integer id) {
		return cOp.findById(id);
	}
*/
	@Override
	public List<Customers> findAll() {
		return cOp.findAll();
	}

	@Override
	public void saveOrUpdate(Customers customer) {

		if (findById(customer.getId())==null) {
			cOp.save(customer);
		} else {
			cOp.update(customer);
		}

	}

	@Override
	public void delete(int id) {
		cOp.delete(id);
	}

	@Override
	public Customers findById(Integer id) {
		return cOp.findById(id);
	}

}
