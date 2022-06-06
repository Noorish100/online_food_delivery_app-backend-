package com.foodApp.repository;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.foodApp.model.Item;

@Repository
public interface ItemDao extends JpaRepository<Item,Integer>{
	 
	
	
}
