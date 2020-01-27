package com.chrisxie.service;

import java.util.List;

import com.chrisxie.model.Customer;

public interface CustomerService {

	public List<Customer> getCustomerList();
	
	public Customer getCustomer(int customerId);
	
	public void saveCustomer(Customer customerTosSave);
	
	public void deleteCustomer(int customerId);
	
}
