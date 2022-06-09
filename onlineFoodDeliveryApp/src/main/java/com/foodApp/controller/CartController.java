package com.foodApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foodApp.Exception.NotFoundException;
import com.foodApp.UserLogin.service.CurrentUserSessionService;
import com.foodApp.model.FoodCart;
import com.foodApp.model.Restaurant;
import com.foodApp.service.CartService;

@RestController
public class CartController{
	
	@Autowired
	private CartService cartService;
	@Autowired
	private CurrentUserSessionService  currentUserSessionService;
	
	@PostMapping("/cart/{cartId}/{itemId}")
	public ResponseEntity<FoodCart> saveCartDetails(@PathVariable ("cartId") Integer cartid, @PathVariable ("itemId") Integer itemid)
	{
		
		FoodCart savedCart = cartService.addItemToCart(cartid, itemid);
		return new ResponseEntity<FoodCart>(savedCart,HttpStatus.CREATED);
	}
	
//-------------------------------Login authentication added------------------------------------	j
	@PostMapping("/cart")
	public ResponseEntity<FoodCart> saveCartDetails(@RequestParam String key,@RequestBody FoodCart fc)
	{
				Integer sessionId = currentUserSessionService.getCurrentUserSessionId(key);
				
				if(fc!=null && sessionId != null) {
	            FoodCart f= cartService.saveCart(fc);
	            	return new ResponseEntity<FoodCart>(f,HttpStatus.CREATED);
	            }
	            throw new NotFoundException();
	}
	//-------------------------------Login authentication added------------------------------------	j	
	@GetMapping("/cartById/{cartId}")
	public FoodCart getCartByCartId(@PathVariable ("cartId") Integer cartId,@RequestParam String key){
		
		Integer sessionId = currentUserSessionService.getCurrentUserSessionId(key);
		if(sessionId != null)
			return cartService.viewCartByCartId(cartId);
		else
			 throw new NotFoundException();
			
	}
	
	@DeleteMapping("/cart/{cartId}")
	public FoodCart deleteCart(@PathVariable ("cartId") Integer cartId){
		
		return cartService.removeCart(cartId);
	}	
}
