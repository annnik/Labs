package customers;
import java.util.List;

import com.lab.entities.Customers;
public interface CustomersService {
	Customers findById(Integer id);

	List<Customers> findAll();

	void saveOrUpdate(Customers user);

	void delete(int id);
}
