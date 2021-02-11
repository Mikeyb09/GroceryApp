package com.groceryapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="grocery_item")
public class GroceryItem {

	@Id
	@Column(name="item_id", unique=true, nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Setter(AccessLevel.NONE)
	private int itemId;
	
	@Column(name="item_name", nullable=false)
	private String itemName;
	
	@Column(name="item_type", nullable=false)
	private String itemType;
	
	@Column(name="item_price", nullable=false)
	private double itemPrice;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="grocery_list_id")
	private GroceryList gList;
	
	public GroceryItem(String itemName, String itemType, double itemPrice) {
		super();
		this.itemName = itemName;
		this.itemType = itemType;
		this.itemPrice = itemPrice;
	}
	
}
