package com.foodApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.foodApp.model.FoodCart;
import com.foodApp.model.Restaurant;
import com.foodApp.service.CartService;

@RestController
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@PostMapping("/cart/{customerId}/{itemName}")
	public ResponseEntity<FoodCart> saveCartDetails(@PathVariable ("customerId") Integer customerId, @PathVariable ("itemName") String itemName)
	{
		FoodCart savedCart = cartService.addItemToCart(customerId, itemName);
		return new ResponseEntity<FoodCart>(savedCart,HttpStatus.CREATED);
	}
	
	@GetMapping("/cartById/{cartId}")
	public Restaurant getCartByCartId(@PathVariable ("cartId") Integer cartId){
			
		return cartService.viewCartByCartId(cartId);		
	}
	
	@DeleteMapping("/cart/{cartId}")
	public Restaurant deleteCart(@PathVariable ("cartId") Integer cartId){
		
		return cartService.removeCart(cartId);
	}	
}
