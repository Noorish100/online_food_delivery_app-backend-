package com.foodApp.service;

import javax.validation.Valid;
import com.foodApp.Exception.ItemUnavailable;
import com.foodApp.model.FoodCart;
import com.foodApp.model.Restaurant;

public interface CartService{	
	
	public FoodCart addItemToCart(Integer customerId, String itemName) throws ItemUnavailable;
//	public List<CartItem> getCartItems(String token);
//	public Cart removeItemFromCart(CartDto cartDto,String token) throws ItemUnavailable;

	public FoodCart saveCart(FoodCart cart)throws ItemUnavailable;

	public FoodCart viewCartByCartId(Integer cartId)throws ItemUnavailable;

	public Restaurant removeCart(Integer cartId)throws ItemUnavailable;

}

