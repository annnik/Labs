package customers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lab.entities.Customers;

public class CustomersMapper implements RowMapper<Customers> {

	public Customers mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customers customer = new Customers();
		customer.setName(rs.getString("name"));
		
		return customer;
	}
}