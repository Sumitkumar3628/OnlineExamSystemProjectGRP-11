package com.exam.service;


import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.dao.RoleDao;
import com.exam.dao.UserDao;
import com.exam.dao.UserRoleDao;
import com.exam.entity.LoginCred;
import com.exam.entity.Role;
import com.exam.entity.User;
import com.exam.entity.UserRole;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private UserDao u_dao;
	
	@Autowired
	private RoleDao r_dao;
	
	@Autowired
	private UserRoleDao ur_dao;

	@Override
	public String validator(LoginCred lc) {
		
		Optional<User> local_d = Optional.ofNullable(this.u_dao.findByUsername(lc.getUsername()));
		User local;
		/*System.out.println(local.getUsername());
		System.out.println(local.getPassword());
		System.out.println(lc.getUsername());
		System.out.println(lc.getPassword());*/
		
		//UserRole urole = ur_dao.getReferenceById(local.getId());
		
		if(local_d.isPresent()) {
			local=local_d.get();
		}else {
			return "false";
		}
		
		//System.out.println("Role Id : "+this.ur_dao.findById(12));
		
		
		if(local!=null && lc.getPassword().equals(local.getPassword())) { 
			/*if(r.getRoleName().equals("ADMIN")) {
				System.out.println("inside 2nd if");
				return "true";
			}
			System.out.println("inside 2nd if");*/
			return "true";
		}
		/*System.out.println("outside 2nd if");*/
		return "user";
	}

	@Override
	public User getUser(String username) {
		User local = this.u_dao.findByUsername(username);
		return local;
	}

	@Override
	public String getRole(String username) {
		User local = this.u_dao.findByUsername(username);
		
		//Optional<User> local2 = Optional.ofNullable(this.u_dao.findByUsername(username));
		//System.out.println("When given Invalid Credentials : "+local2);
		
		if(local!=null) {
			Set<UserRole> userRoleSet = local.getUserRoles();
			Role r = new Role();
			for(UserRole u:userRoleSet) {
				r = u.getRole();
			}
			
			if(r.getRoleName().equals("ADMIN")) {
				//if true than admin
				return "true";
			}
			//if false than user
		}
			
		return "false";
	}
	
	

	

}
