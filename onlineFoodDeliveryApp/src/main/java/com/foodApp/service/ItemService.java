package com.foodApp.service;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Component;

import com.foodApp.model.Item;
import com.foodApp.model.Resturant;


public interface ItemService {
	
	public Item addItem(Item i)throws NotFoundException;
	
	public Item updateItem(Item i)throws NotFoundException;
	
	public Item removeItem(Integer itemId)throws NotFoundException;
	
	public Item viewItem(Integer itemId)throws NotFoundException;
	
	public List<Item> viewAllItemResturant(Resturant res)throws NotFoundException;

	public List<Item> viewAllItemByName(String name)throws NotFoundException;
}
