package com.groceryapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groceryapp.model.User;
import com.groceryapp.repository.UserDao;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor(onConstructor=@__(@Autowired))
@NoArgsConstructor
public class UserService {
	
	private UserDao userDao;
	
	public List<User> getAllUsers(){
		return userDao.findAll();
	}
	
	public User getUserById(int id) {
		return userDao.findByUserId(id);
	}
	
	public User getUserByUsername(String username) {
		return userDao.findByUsername(username);
	}
	
	public void insertUser(User user) {
		userDao.save(user);
	}
	
	public void deleteUser(User user) {
		userDao.delete(user);
	}

}
