package com.foodApp.repository;

import com.foodApp.model.OrderDetails;

import org.springframework.data.jpa.repository.JpaRepository;



public interface OrderDao extends JpaRepository<OrderDetails,Integer> {

}
