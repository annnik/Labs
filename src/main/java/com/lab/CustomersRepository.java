package com.lab;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.*;

import com.lab.entities.Customers;

public interface CustomersRepository extends CrudRepository<Customers, String>{
	@Query("SELECT u FROM Customer")
	List<Customers> findAllCustomers();
}
