package com.foodApp.controller;

import java.util.List;

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
import com.foodApp.model.Item;
import com.foodApp.model.Resturant;
import com.foodApp.service.ItemService;
import com.foodApp.service.ItemServiceImpl;

@RestController
public class ItemController{
		
	@Autowired
	private ItemService iSer;
	
	@PostMapping("/Item")
	public Item saveItem(@Valid @RequestBody Item item) {
		
		Item i = iSer.addItem(item);
		
		return i;
	}
	
	@PutMapping("/Item")
	public ResponseEntity<Item> updateItem(@Valid @RequestBody Item item){
		
		Item updatedResturant=iSer.updateItem(item);
		
		return new ResponseEntity<Item>(updatedResturant,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/Item/{itemId}")
	
	public Item deleteItemById(@PathVariable("itemId") Integer itm){
		
		return iSer.removeItem(itm);
	}
		
	
	@GetMapping("/Item/{itemId}")
	public Item getItemByItemId(@PathVariable("itemId") Integer itm) {
			
		return iSer.viewItem(itm);
	}

	@GetMapping("/resturant/{resturantName}")
	public ResponseEntity<List<Item>> viewResturant(String name){
		List<Item> items= iSer.(name);
	
		return new ResponseEntity<List<Item>>(items, HttpStatus.OK);
	}
}

