package com.groceryapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groceryapp.model.GroceryList;
import com.groceryapp.repository.GroceryListDao;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor(onConstructor=@__(@Autowired))
@NoArgsConstructor
public class GroceryListService {
	
	public GroceryListDao glDao;
	
	public List<GroceryList> getAllLists(){
		return glDao.findAll();
	}
	
	public GroceryList getGroceryListById(int id) {
		return glDao.findByGroceryListId(id);
	}
	
	public void insertGroceryList(GroceryList gList) {
		glDao.save(gList);
	}
	
	public void deleteGroceryList(int id) {
		glDao.deleteById(id);
	}

}
