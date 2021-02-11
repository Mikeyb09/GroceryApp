package com.groceryapp.controller;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groceryapp.model.User;
import com.groceryapp.service.UserService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@CrossOrigin("*")
@RestController
@RequestMapping(value="/users")
@AllArgsConstructor(onConstructor=@__(@Autowired))
@NoArgsConstructor
public class UserController {
	
	private UserService userServ;
	
	@PostMapping()
	public ResponseEntity<String> insertUser(@RequestBody LinkedHashMap<String, String> userMap){
		System.out.println(userMap);
		User user = new User(userMap.get("username"), userMap.get("password"), userMap.get("firstName"), userMap.get("lastName"), userMap.get("email"));
		userServ.insertUser(user);
		return new ResponseEntity<>("User was created", HttpStatus.CREATED);
	}
	
	@PostMapping("/login-user")
	public ResponseEntity<User> userLogin(@RequestBody LinkedHashMap<String, String> userMap){
		
		System.out.println(userMap.get("username") + " : " + userMap.get("password"));
		
		if(userServ.getUserByUsername(userMap.get("username")) == null) {
			System.out.println("Could not find by username");
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			User user = userServ.getUserByUsername(userMap.get("username"));
			if(user.getPassword().equals(userMap.get("password"))) {
				System.out.println("Match found...");
				return new ResponseEntity<>(user, HttpStatus.OK);
			} else {
				System.out.println("password did not match");
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			}
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") int id){
		
		if(userServ.getUserById(id) == null) {
			return new ResponseEntity<>(null, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(userServ.getUserById(id), HttpStatus.OK);
	}

}
