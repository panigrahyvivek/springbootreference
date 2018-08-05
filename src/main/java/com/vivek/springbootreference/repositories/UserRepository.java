package com.vivek.springbootreference.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vivek.springbootreference.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {


}