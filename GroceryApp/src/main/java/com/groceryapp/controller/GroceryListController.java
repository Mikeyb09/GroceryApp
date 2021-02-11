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

import com.groceryapp.model.GroceryList;
import com.groceryapp.service.GroceryItemService;
import com.groceryapp.service.GroceryListService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@CrossOrigin("*")
@RestController
@RequestMapping(value="/grocery-list")
@AllArgsConstructor(onConstructor=@__(@Autowired))
@NoArgsConstructor
public class GroceryListController {

	private GroceryListService glServ;
	private GroceryItemService giServ;
	
	
	@PostMapping("/new-list")
	public ResponseEntity<String> createNewList(@RequestBody LinkedHashMap<String, String> glMap){
		GroceryList gList = new GroceryList(glMap.get("listName"));
		glServ.insertGroceryList(gList);
		return new ResponseEntity<>("Grocery List was created", HttpStatus.CREATED);
				
	}
	
	@PostMapping("/items")
	public ResponseEntity<String> addItemToList(@RequestBody LinkedHashMap<String, Integer> glMap) {
		
	}
	
	@GetMapping("/get-list/{id}")
	public ResponseEntity<GroceryList> getGroceryListById(@PathVariable("id") int id){
		if(glServ.getGroceryListById(id) == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(glServ.getGroceryListById(id), HttpStatus.OK);
		}
	}
	
}
