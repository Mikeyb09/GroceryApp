package com.groceryapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groceryapp.model.GroceryItem;
import com.groceryapp.repository.GroceryItemDao;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor(onConstructor=@__(@Autowired))
@NoArgsConstructor
public class GroceryItemService {
	
	public GroceryItemDao giDao;
	
	public List<GroceryItem> getAllItems(){
		return giDao.findAll();
	}
	
	public GroceryItem getItemById(int id) {
		return giDao.findItemByItemId(id);
	}
	
	public void insertGroceryItem(GroceryItem gItem) {
		giDao.save(gItem);
	}
	
	public void deleteGroceryItem(int id) {
		giDao.deleteById(id);
	}

}
