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

import com.groceryapp.model.GroceryItem;
import com.groceryapp.service.GroceryItemService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@CrossOrigin("*")
@RestController
@RequestMapping(value="/grocery-item")
@AllArgsConstructor(onConstructor=@__(@Autowired))
@NoArgsConstructor
public class GroceryItemController {

	private GroceryItemService giServ;
	
	@PostMapping("/new-item")
	public ResponseEntity<String> createNewItem(@RequestBody LinkedHashMap<String, String> itemMap){
		GroceryItem gItem = new GroceryItem(itemMap.get("itemName"), itemMap.get("itemType"), Double.parseDouble(itemMap.get("itemPrice")));
		giServ.insertGroceryItem(gItem);
		return new ResponseEntity<>("Item was created", HttpStatus.CREATED);
	}
	
	@GetMapping("/get-item/{id}")
	public ResponseEntity<GroceryItem> getItemById(@PathVariable("id") int id){
		if(giServ.getItemById(id) == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(giServ.getItemById(id), HttpStatus.OK);
		}
	}
	
}
