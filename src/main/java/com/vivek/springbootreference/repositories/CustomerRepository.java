package com.vivek.springbootreference.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.vivek.springbootreference.models.Customer;

@RepositoryRestResource
public interface CustomerRepository extends CrudRepository<Customer, Long> { }