package com.foodApp.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.foodApp.model.Resturant;


public interface ResturantService {

	public Resturant addResturant(Resturant res);
	
	public Resturant updateResturant(Resturant res);
	
	public Resturant removeResturant(Integer resturantId);
	
	public Resturant viewResturantByResturantId(Integer resturantId);
	
	public List<Resturant> viewNearByResturant(String location);
	
	public List<Resturant> viewResturantByItemName(String name);
}
