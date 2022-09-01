package com.exam.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.exam.entity.Role;
import com.exam.entity.User;
import com.exam.entity.UserRole;
import com.exam.exceptions.UserAlreadyPresent;


@SpringBootTest
class UserServiceImplTest {
	
	@Autowired
	private UserServiceImpl userv;
	
	
	
	@Test
	@Disabled
	void testCreateUser() throws UserAlreadyPresent {
		User user2 = new User(2,"user2","1234","User2","Name2","user@gmail.com","1234567890","Haryana","Faridabad",true,"User2");
		User user3 = new User(3,"user3","1234","User3","Name3","user@gmail.com","1234567890","Haryana","Faridabad",true,"User3");
		User user4 = new User(4,"user4","1234","User4","Name4","user@gmail.com","1234567890","Haryana","Faridabad",true,"User4");
		User user5 = new User(5,"user5","1234","User5","Name5","user@gmail.com","1234567890","Maharastra","Mumbai",true,"User5");
		User user6 = new User(6,"user6","1234","User6","Name6","user@gmail.com","1234567890","Maharastra","Mumbai",true,"User6");
		User user7 = new User(7,"user7","1234","User7","Name7","user@gmail.com","1234567890","Maharastra","Mumbai",true,"User7");
		User user8 = new User(8,"user8","1234","User8","Name8","user@gmail.com","1234567890","Maharastra","Mumbai",true,"User8");
		User user9 = new User(9,"user9","1234","User9","Name9","user@gmail.com","1234567890","Maharastra","Mumbai",true,"User9");
		User user10 = new User(10,"user10","1234","User10","Name10","user@gmail.com","1234567890","Maharastra","Mumbai",true,"User10");
		Role role = new Role();
		
		role.setRoleId(45);
		role.setRoleName("USER"); //demo code to see the working
		
		UserRole userrole=new UserRole();
		userrole.setRole(role);
		userrole.setUser(user10);
		
		
		Set<UserRole> roles=new HashSet<>();
		roles.add(userrole);
//		User u2 = this.userv.createUser(user2, roles);
//		User u3 = this.userv.createUser(user3, roles);
//		User u4 = this.userv.createUser(user4, roles);
//		User u5 = this.userv.createUser(user5, roles);
//		User u6 = this.userv.createUser(user6, roles);
//		User u7 = this.userv.createUser(user7, roles);
//		User u8 = this.userv.createUser(user8, roles);
//		User u9 = this.userv.createUser(user9, roles);
		User u10 = this.userv.createUser(user10, roles);
		assertEquals("User10", null);
	}

	@Test
	@Disabled
	void testGetUser() {
		User u1 = userv.getUser("user6");
		assertEquals("user@gmail.com",u1.getEmail());
		}

	@Test
	void testDeleteUser() {
		User u1 = userv.getUser("user6");
		userv.deleteUser(u1.getId());
		User u2 = userv.getUser("user6");
		assertNull(u2);
	}

	@Test
	@Disabled
	void testGetAllUser() throws UserAlreadyPresent {
//		User user = new User(5,"user5","123456","User5","Name5","user5@gmail.com","1234567890",true,"User5");
//		Role role=new Role();
//		role.setRoleId(45);
//		role.setRoleName("User"); //demo code to see the working
//		
//		UserRole userrole=new UserRole();
//		userrole.setRole(role);
//		userrole.setUser(user);
//		
//		
//		Set<UserRole> roles=new HashSet<>();
//		roles.add(userrole);
//		User u1 = userv.createUser(user, roles);
//		
		List<User> ulist = userv.getAllUser();
		List<User> ulist2 = new ArrayList<User>();
		System.out.println(ulist);
		String result = null;
		for(User u:ulist) {
			if(u.getState().equals("Maharastra") && u.getCity().equals("Mumbai")) {
				ulist2.add(u);
			}
		}
		System.out.println(ulist2);
		
	}

}