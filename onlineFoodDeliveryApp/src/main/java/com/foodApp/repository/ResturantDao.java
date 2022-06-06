package com.foodApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodApp.model.Resturant;

public interface ResturantDao extends JpaRepository<Resturant, Integer>{
	
	
}

