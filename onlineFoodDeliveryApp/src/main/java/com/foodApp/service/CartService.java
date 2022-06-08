package com.foodApp.service;

import java.util.List;

import com.foodApp.model.Cart;
import com.foodApp.model.Item;

public interface CartService{
	public List<Item> getCartId(Integer cart_Id, Integer user_Id );
	
	public Cart getCartById(Integer cartId);
	
	public Item getItembyId(Integer restId, Integer itemId);
	
	public Cart storeItemwithUser(Integer userId, Integer cartId, Integer itemId , Integer quantity);
    
	public String delivery(Integer cartId);
}

