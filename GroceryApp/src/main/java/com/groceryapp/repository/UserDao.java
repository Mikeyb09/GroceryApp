package com.groceryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.groceryapp.model.User;

public interface UserDao extends JpaRepository<User, Integer>{
	
	public List<User> findAll();
	public User findByUserId(int userId);
	public User findByUsername(String username);

}
