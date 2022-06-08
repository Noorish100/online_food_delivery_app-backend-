package com.foodApp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class CartItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cartItemId;
	
//	@OneToOne
//	@JsonIgnoreProperties(value={
//			"itemId",
//			"resturant",
//			"quantity"
//			
//	})
	private Item cartItem;
	
	private Integer cartItemQuantity;
}