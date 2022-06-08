package com.foodApp.repository;

import com.foodApp.model.Orders;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersDao extends JpaRepository<Orders,Integer> {

}
