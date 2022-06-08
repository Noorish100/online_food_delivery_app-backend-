package com.foodApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodApp.model.Customer;

@Repository
public interface CustomerDAO extends JpaRepository<Customer,Integer> {

}
