package customers;
import java.util.List;

import com.lab.entities.Customers;
public interface CustomersOperationsInterface {
	Customers findById(Integer id);

	List<Customers> findAll();

	void save(Customers customer);

	void update(Customers customer);

	void delete(Integer id);
}
