package com.foodApp.repository;

import java.beans.JavaBean;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodApp.model.Resturant;
@Repository
public interface ResturantDao extends JpaRepository<Resturant, Integer>{
	
	
}

 