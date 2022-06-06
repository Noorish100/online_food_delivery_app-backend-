package com.foodApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.foodApp.model.Resturant;
import com.foodApp.service.ResturantService;

@RestController
public class ResturantController{
	
	@Autowired
	private ResturantService resSer;
	
	@PostMapping("/Resturant")
	public Resturant saveResturant(@RequestBody Resturant res) {
		
		Resturant r = resSer.addResturant(res);
		
		return r;
	}
}
