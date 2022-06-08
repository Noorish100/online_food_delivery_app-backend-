package com.foodApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.foodApp.model.Cart;


@Repository
public interface CartDao extends JpaRepository<Cart,Integer>{
	
}