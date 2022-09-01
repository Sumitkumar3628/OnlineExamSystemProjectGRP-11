package com.exam.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.dao.UserDao;
import com.exam.entity.LoginCred;
import com.exam.entity.User;
import com.exam.service.LoginServiceImpl;


@RestController
@RequestMapping("/login")
@CrossOrigin("*")
public class LoginController {
	
	@Autowired
	private LoginServiceImpl loginservice;
	
	@PostMapping("/")
	public String generateToken(@RequestBody LoginCred lc) {
		
		return this.loginservice.validator(lc);
	}
	
	@GetMapping("/getuser/{username}")
	public User getUserDetails(@PathVariable("username")String username) {
		return this.loginservice.getUser(username);
	}
	
	@GetMapping("/isadmin/{username}")
	public String isAdmin(@PathVariable("username")String username) {
		
		return this.loginservice.getRole(username);
	}
	
	
	
	

}
