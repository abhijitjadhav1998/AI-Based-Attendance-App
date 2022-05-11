package com.abhijit.aibasedattendanceapp.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.abhijit.aibasedattendanceapp.entity.Role;
import com.abhijit.aibasedattendanceapp.entity.User;
import com.abhijit.aibasedattendanceapp.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public User save(User registrationDto) {
		System.out.println(registrationDto.getUserName() + " " + registrationDto.getPassword());
		User user = new User(registrationDto.getUserName(),
				new BCryptPasswordEncoder().encode(registrationDto.getPassword()), Arrays.asList(new Role("ADMIN")));

		return userRepository.save(user);
	}

	public String validateUserName(String username) {
		String message = "";
		if (username.equals("")) {
			message += "UserName is mandatory <br>";
		} else if (getEmployeeByUsername(username)) {
			message += "User Already Exists <br>";
		}
		return message;
	}

	public boolean getEmployeeByUsername(String username) {
		boolean status = false;
		User user = userRepository.findByUserName(username);
		if (user != null) {
			status = true;
		}
		return status;
	}

	public String validatePassword(String password) {
		String message = "";
		if (password.equals("")) {
			message += "Password is mandatory <br>";
		}

		if (password.length() < 6) {
			message += "Password Should be of minumum 6 characters only <br>";
		}
		return message;
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(userName);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
				mapRolesToAuthorities(user.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

}