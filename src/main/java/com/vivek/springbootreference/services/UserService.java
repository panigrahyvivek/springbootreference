package com.vivek.springbootreference.services;

import java.util.Arrays;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vivek.springbootreference.controllers.MyController;
import com.vivek.springbootreference.models.User;
import com.vivek.springbootreference.models.UserDto;
import com.vivek.springbootreference.repositories.UserRepository;

@Service
public class UserService implements IUserService{
	private static final Logger log = LoggerFactory.getLogger(MyController.class); 
	
	@Autowired
    private UserRepository repository;

	@Transactional
	@Override
	public User registerNewUserAccount(UserDto accountDto) {
		
		
		User user = new User();    
		user.setId(1);
        user.setFirstName(accountDto.getFirstName());
        user.setEmail(accountDto.getEmail());
//      user.setRoles(Arrays.asList("ROLE_USER"));
        return repository.save(user);
	}
	
	
} 