package customers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lab.entities.Customers;

public class CustomersOperations implements CustomersOperationsInterface{
	
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	private CustomersService customerService;
	@Autowired
	public void setNamedParameterJdbcTemplate(
		NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	public List<Customers> findAll() {

		String sql = "SELECT * FROM CUSTOMERS";
		List<Customers> result = namedParameterJdbcTemplate.query(sql, new CustomersMapper());
		return result;

	}
	
	public void save(Customers customer) {

		

		String sql = "INSERT INTO CUSTOMERS(NAME) "
				+ "VALUES ( :name)";

		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(customer));
		

	}

	
	public void update(Customers customer) {

		String sql = "UPDATE CUSTOMERS SET NAME=:name WHERE id=:id";

		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(customer));

	}

	
	public void delete(Integer id) {

		String sql = "DELETE FROM CUSTOMERS WHERE id= :id";
		namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource("id", id));

	}
	
	private SqlParameterSource getSqlParameterByModel(Customers customer) {

		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		
		paramSource.addValue("name", customer.getName());
		

		return paramSource;
	}
	
	
	
	@Override
	public Customers findById(Integer id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);

		String sql = "SELECT * FROM CUSTOMERS WHERE id=:id";

		Customers result = null;
		try {
			result = namedParameterJdbcTemplate
                          .queryForObject(sql, params, new CustomersMapper());
		} catch (EmptyResultDataAccessException e) {
			// do nothing, return null
		}

		return result;
	}
}
