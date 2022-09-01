package com.exam.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.exam.entity.User;

public interface UserDao extends JpaRepository<User, Integer> {

	public User findByUsername(String username);
	public User findById(int id);
	public List<User> findAllByState(String state);
	public List<User> findAllByCity(String city);
}
