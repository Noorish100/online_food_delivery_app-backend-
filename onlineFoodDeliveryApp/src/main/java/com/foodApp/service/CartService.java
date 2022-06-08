package com.foodApp.service;

import java.util.List;

import com.foodApp.model.Cart;
import com.foodApp.model.Item;

public interface CartService{	
	
	public Cart addItemToCart(Cart cart, Item item);
	
	public Cart increaseQuantity(Cart cart, Item item, Integer quantity);
	
	public Cart reduceQuantity(Cart cart, Item item, Integer quantity);
	
	public Cart removeItem(Cart cart, Item item);
	
	public Cart clearCart(Cart cart);
}

