package com.groceryapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="grocery_list")
public class GroceryList {
	
	@Id
	@Column(name="grocery_list_id", unique=true, nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Setter(AccessLevel.NONE)
	private int groceryListId;
	
	@Column(name="name_of_list", nullable=false)
	private String nameOfList;
	
	@Column(name="list_price")
	private int listPrice;
	
	
	public GroceryList(String listName) {
		super();
		this.nameOfList = listName;
	}

}
