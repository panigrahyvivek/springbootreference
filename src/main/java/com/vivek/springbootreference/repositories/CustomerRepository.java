package com.vivek.springbootreference.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.vivek.springbootreference.models.Customer;
import com.vivek.springbootreference.models.Employee;

@Repository
public interface CustomerRepository extends CrudRepository<Employee, Long> { 
	List<Employee> findByName (String name); 
}