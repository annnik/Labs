package com.lab;

import javax.annotation.PostConstruct;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.lab.entities.Customers;
import com.lab.repositories.CustomersRepository;

@SpringBootApplication
public class ServerSide {
	@Autowired
	CustomersRepository customersRepository;
	public static void main(String[] args) {
		SpringApplication.run(ServerSide.class, args);
	}
	@PostConstruct
	private void init() {
		Customers onec = new Customers();
		onec.setName("admin");
		customersRepository.save(onec);
		customersRepository.findAll();
		// mvnw install - собрать
		// mvnw clean install - совсем собрать
		// mvnw spring-boot:run - запустить
	
	}

}