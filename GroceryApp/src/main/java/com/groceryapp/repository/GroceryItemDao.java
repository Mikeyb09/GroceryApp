package com.groceryapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groceryapp.model.GroceryItem;

public interface GroceryItemDao extends JpaRepository<GroceryItem, Integer>{

	public List<GroceryItem> findAll();
	public GroceryItem findItemByItemId(int id);
	
}
