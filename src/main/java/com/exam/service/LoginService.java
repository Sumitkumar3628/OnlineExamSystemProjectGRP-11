package com.exam.service;

import com.exam.entity.LoginCred;
import com.exam.entity.User;

public interface LoginService {
	
	public String validator(LoginCred lc);
	public User getUser(String username);
	public String getRole(String username);
	

}
