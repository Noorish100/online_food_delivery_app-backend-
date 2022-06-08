package com.foodApp.service;

import com.foodApp.Exception.CustomerException;
import com.foodApp.model.Customer;

public interface CustomerService {
	
	public Customer saveCustomer(Customer customer);
	public Customer updateCustomer(Customer customer) throws CustomerException;
	public Customer removeCustomerById(Integer customerId)throws CustomerException;
	public Customer viewCustomer(Integer customerId) throws CustomerException;

}
