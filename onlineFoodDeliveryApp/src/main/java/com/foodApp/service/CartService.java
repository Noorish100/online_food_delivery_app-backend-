package com.foodApp.service;

import javax.validation.Valid;
import com.foodApp.Exception.ItemUnavailable;
import com.foodApp.model.Cart;
import com.foodApp.model.Resturant;

public interface CartService{	
	
	public Cart addItemToCart(Integer customerId, String itemName) throws ItemUnavailable;
//	public List<CartItem> getCartItems(String token);
//	public Cart removeItemFromCart(CartDto cartDto,String token) throws ItemUnavailable;

	public Cart saveCart(Cart cart);

	public Resturant viewCartByCartId(Integer cartId);

	public Resturant removeCart(Integer cartId);

	public Cart updateCart(@Valid Cart cart);
}

