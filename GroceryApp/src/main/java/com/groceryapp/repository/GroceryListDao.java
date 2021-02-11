package com.groceryapp.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groceryapp.model.GroceryList;
import com.groceryapp.model.User;

public interface GroceryListDao extends JpaRepository<GroceryList, Integer>{

	public List<GroceryList> findAll();
	public GroceryList findByGroceryListId(int id);	
	
}
