package com.lab.repositories;

import org.springframework.data.repository.*;

import com.lab.entities.Customers;

public interface CustomersRepository extends CrudRepository<Customers, String>{
}