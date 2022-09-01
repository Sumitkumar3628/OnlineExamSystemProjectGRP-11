package com.exam;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.exam.entity.Role;
import com.exam.entity.User;
import com.exam.entity.UserRole;
import com.exam.service.UserService;

@SpringBootApplication
public class OnlineExamSystemServerApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(OnlineExamSystemServerApplication.class, args);
		System.out.println("Working");
	}

	@Override
	public void run(String... args) throws Exception {
//		User user = new User();
//
//		user.setUsername("surajsoni878");
//		user.setPassword("2323");
//		user.setFirstName("Suraj");
//		user.setMiddleName("Kumar");
//		user.setLastName("Soni");
//		user.setEmail("suraj@soni");
//		user.setCity("Tata");
//		user.setState("Jharkhand");
//		user.setDob("1999");
//		user.setPhone("999999999");
//		user.setProfile("default.png");
		
		
//		private int id;
//		private String username;//d
//		private String password;//d
//		private String firstName;//d
//		private String middleName;//d
//		private String lastName;//d
//		private String email;//d
//		private String city;
//		private String state;
//		private String dob;
//		private String phone;//d
//		private boolean enabled = true;
//		private String profile;//d

//		Role role1 = new Role();
//		role1.setRoleId(1);
//		role1.setRoleName("IT");
//
//		UserRole userRoles = new UserRole();
//		userRoles.setRole(role1);
//		userRoles.setUser(user);
//
//		Set<UserRole> userSet = new HashSet<UserRole>();
//		userSet.add(userRoles);
//
//		User user1 = this.userService.createUser(user, userSet);
//		System.out.println(user1.getUsername());

	}

}
