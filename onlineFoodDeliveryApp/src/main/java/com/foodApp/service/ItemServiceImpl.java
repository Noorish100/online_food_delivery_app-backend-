package com.foodApp.service;
import java.util.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.foodApp.model.Item;
import com.foodApp.model.Resturant;
import com.foodApp.repository.ItemDao;
import com.foodApp.repository.ResturantDao;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;


@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	private ItemDao ida;
	
	@Autowired
	private ResturantDao ra;

	@Override
	public Item addItem(Item i) {
		// TODO Auto-generated method stub
		return ida.save(null);
	}

	@Override
	public Item updateItem(Item i) {
		// TODO Auto-generated method stub
		java.util.Optional<Item> optI = ida.findById(i.getItemId());
				
		if(optI.isPresent()) {
			
			Item existingItem= optI.get();
			
			return ida.save(i);
		}
		return null;
	}
	


	@Override
	public Item removeItem(Item i) {
java.util.Optional<Item> optI = ida.findById(i.getItemId());
		
		if(optI.isPresent()) {
			
			Item existingResturant= optI.get();
			
			
		   ida.delete(existingResturant);
		   
		   return existingResturant;
		}
		return null;
	}

	@Override
	public Item viewItem(Item i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> viewAllItemResturant(Resturant res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> viewAllItemByName(String name) {
		
		Resturant n= ra.findByName(name);
		
		if(n!=null) {
			
			List<Item> il=n.getItemlist();
			
			return il;
		}
		return null;
		
	}
}
	
	
	
	
	
	
	
	
