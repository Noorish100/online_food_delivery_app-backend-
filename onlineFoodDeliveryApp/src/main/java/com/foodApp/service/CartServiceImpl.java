package com.foodApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodApp.Exception.ItemUnavailable;
import com.foodApp.model.Cart;
import com.foodApp.model.CartDto;
import com.foodApp.model.CartItem;
import com.foodApp.model.Customer;
import com.foodApp.model.Item;
import com.foodApp.model.Resturant;
import com.foodApp.repository.CartDao;
import com.foodApp.repository.CustomerDAO;
import com.foodApp.repository.ItemDao;


@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartDao cartDao;
	@Autowired
	private Customer customer;
	
	@Autowired
	private ItemDao itemDao;
	
	@Autowired
	private CustomerDAO customerDAO;

	@Override
	public Cart addItemToCart(Integer id, String item) throws ItemUnavailable {
		
		
		Optional<Customer> optR = customerDAO.findById(id);
		
		if(optR.isPresent()) {
			
			Item i = itemDao.findByItemName(item);
			
			if(i != null) {
			  return cartDao.save(customer.getCart());
			}
		}		
		//private List<Item> items = new ArrayList<>();
		return null;
	}

	@Override
	public Cart saveCart(Cart cart) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resturant viewCartByCartId(Integer cartId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resturant removeCart(Integer cartId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cart updateCart(@Valid Cart cart) {
		// TODO Auto-generated method stub
		return null;
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


