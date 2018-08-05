package com.vivek.springbootreference.services;


import com.vivek.springbootreference.models.User;
import com.vivek.springbootreference.models.UserDto;

public interface IUserService {
    User registerNewUserAccount(UserDto accountDto);
}