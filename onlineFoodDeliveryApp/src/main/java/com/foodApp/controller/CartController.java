package com.foodApp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.foodApp.model.Cart;
import com.foodApp.model.Customer;
import com.foodApp.model.Resturant;
import com.foodApp.service.CartService;

@RestController
public class CartController {
	
	
	@Autowired
	private CartService cartService;
	
	@PostMapping("/cart/{customerId}/{itemName}")
	public ResponseEntity<Cart> saveCartDetails(@PathVariable ("customerId") Integer customerId, @PathVariable ("itemName") String itemName)
	{
		Cart savedCart = cartService.addItemToCart(customerId, itemName);
		return new ResponseEntity<Cart>(savedCart,HttpStatus.CREATED);
	}
	
	@GetMapping("/cartById/{cartId}")
	public Resturant getCartByCartId(@PathVariable ("cartId") Integer cartId){
			
		return cartService.viewCartByCartId(cartId);		
	}
	
	@DeleteMapping("/cart/{cartId}")
	public Resturant deleteCart(@PathVariable ("cartId") Integer cartId){
		
		return cartService.removeCart(cartId);
	}	
}
