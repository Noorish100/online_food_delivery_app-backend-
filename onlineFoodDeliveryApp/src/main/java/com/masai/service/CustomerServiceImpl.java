package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.masai.repository.CustomerDAO;
import com.masai.exception.CustomerException;
import com.masai.model.Customer;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO cDao;
	@Override
	public Customer saveCustomer(Customer customer) {
		Customer savedCustomer = cDao.save(customer);
		
		return savedCustomer;
	}
	@Override
	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
		Optional<Customer> opt= cDao.findById(customer.getCustomerId());
		
		if(opt.isPresent()) {
			
			Customer existingCustomer= opt.get();
			
			return cDao.save(customer);
		}
		else
			throw new CustomerException("Invalid customer Details..");
	}
	@Override
	public Customer removeCustomerById(Integer customerId) throws CustomerException {
		// TODO Auto-generated method stub
		Customer existingCustomer= cDao.findById(customerId).orElseThrow( () -> new CustomerException("Customer does not exist with Id :"+customerId) );
		
		cDao.delete(existingCustomer);
		
		return existingCustomer;
	}
	@Override
	public Customer viewCustomer(Integer customerId) throws CustomerException {
		// TODO Auto-generated method stub
		
		Optional<Customer> opt= cDao.findById(customerId);
		
		if(opt.isPresent()) {
			
			Customer customer= opt.get();
			return customer;
			
		}else
			throw new CustomerException("Customer does not exist with Id "+customerId);
		
	}
	
	

}
