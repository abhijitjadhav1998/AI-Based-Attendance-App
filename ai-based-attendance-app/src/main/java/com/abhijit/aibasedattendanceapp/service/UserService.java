package com.abhijit.aibasedattendanceapp.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.abhijit.aibasedattendanceapp.entity.User;

public interface UserService extends UserDetailsService{
	User save(User registrationDto);

	String validateUserName(String userName);

	String validatePassword(String password);
}