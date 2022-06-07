package com.foodApp.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.foodApp.model.Resturant;

@Repository
public interface ResturantDao extends JpaRepository<Resturant, Integer>{
	
	public Resturant findByResturantName(String Name);
}

 