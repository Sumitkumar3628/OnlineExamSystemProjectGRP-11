package com.exam.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.entity.UserRole;

public interface UserRoleDao extends JpaRepository<UserRole, Integer> {

}
