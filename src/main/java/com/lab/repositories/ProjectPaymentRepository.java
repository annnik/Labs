package com.lab.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.*;

import com.lab.entities.ProjectPayment;

public interface ProjectPaymentRepository extends CrudRepository<ProjectPayment, String>{
}
