package com.foodApp.repository;

import java.beans.JavaBean;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.foodApp.model.Resturant;
@Component
public interface ResturantDao extends JpaRepository<Resturant, Integer>{
	
	public Resturant findByName(String Name);
}

 