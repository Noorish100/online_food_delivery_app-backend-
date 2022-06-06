package com.foodApp.service;

import java.util.List;

import com.foodApp.model.Resturant;

public interface ResturantService {

	public Resturant addResturant(Resturant res);
	
	public Resturant updateResturant(Resturant res);
	
	public Resturant removeResturant(Resturant res);
	
	public Resturant viewResturant(Resturant res);
	
	public List<Resturant> viewNearByResturant(String location);
	
	public List<Resturant> viewResturantByItemName(String name);
	
}
