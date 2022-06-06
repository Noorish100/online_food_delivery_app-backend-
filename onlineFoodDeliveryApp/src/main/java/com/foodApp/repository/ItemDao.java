package com.foodApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodApp.model.Item;

public interface ItemDao extends JpaRepository<Item, Integer>{
	 
}
