package com.foodApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodApp.Exception.ItemUnavailable;
import com.foodApp.Exception.NoItemFoundInFoodcart;
import com.foodApp.model.Customer;
import com.foodApp.model.FoodCart;
import com.foodApp.model.Item;
import com.foodApp.model.Restaurant;
import com.foodApp.repository.CartDao;
import com.foodApp.repository.CustomerDAO;
import com.foodApp.repository.ItemDao;


@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private ItemDao itemDao;
	
	@Autowired
	private CustomerDAO customerDAO;
	
	

	@Override
	public FoodCart addItemToCart(Integer id, String item) throws ItemUnavailable {
		
		
		Optional<Customer> optR = customerDAO.findById(id);
		
		if(optR.isPresent()) {
			
			Item i = itemDao.findByItemName(item);
			
			if(i != null) {
			  
				FoodCart c=new FoodCart();
				
				c.getItems().add(i);
				
				
			}
		}		
		
	 throw new NoItemFoundInFoodcart("not found");
	}

	@Override
	public FoodCart saveCart(FoodCart cart) {
		
		if(cart!=null)
		return cartDao.save(cart);
		throw new ItemUnavailable("cant save");
	}

	@Override
	public FoodCart viewCartByCartId(Integer cartId) {
	   Optional<FoodCart> f=cartDao.findById(cartId);
	   if(f.isPresent()) {
       	FoodCart existingcart= f.get();
       	
       	return existingcart;
       	
       	
	   }
		 throw new NoItemFoundInFoodcart("not found");

		
	}

	@Override
	public FoodCart removeCart(Integer cartId) {
		
		   Optional<FoodCart> f=cartDao.findById(cartId);
		   if(f.isPresent()) {
	       	FoodCart existingcart= f.get();
	       	
	       	 cartDao.delete(existingcart);
	       	
	       	return existingcart;
	       	
	       	
		   }
			 throw new NoItemFoundInFoodcart("not found");
		
		
	}



//	@Override
//	public List<CartItem> getCartItems(String token) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Cart removeItemFromCart(CartDto cartDto, String token) throws ItemUnavailable {
//		// TODO Auto-generated method stub
//		return null;
//	}
}


