package com.lab.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.*;

import com.lab.entities.Employees;

public interface EmployeesRepository extends CrudRepository<Employees, String>{
}
