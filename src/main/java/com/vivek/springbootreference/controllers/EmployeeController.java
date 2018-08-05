package com.vivek.springbootreference.controllers;

import java.util.Arrays;
import java.util.List;

//import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.vivek.springbootreference.models.Customer;
import com.vivek.springbootreference.models.Employee;
import com.vivek.springbootreference.models.Greeting;
import com.vivek.springbootreference.models.Quote;
import com.vivek.springbootreference.repositories.CustomerRepository;

@RestController
public class EmployeeController {
	
	
	private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);
	
	CustomerRepository repo;
	
	public EmployeeController(CustomerRepository repo) {
		this.repo = repo;
	}
	
	@RequestMapping("/api/employees")
    public List<Employee> greeting(@RequestParam(value="name", defaultValue="World") String name) {
		return repo.findByName("Priya");
    }
	
}