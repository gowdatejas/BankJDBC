package com.banking.dao;

import java.util.List;

import com.banking.dto.Customer;

public interface CustomerDAO {
	public boolean insertCustomer(Customer c); 
	public Customer getCustomer(long acc_No,int pin); 
	public Customer getCustomer(long phone,String email); 
	public Customer getCustomer(long acc_No); 
	public List getCustomer(); 
	public boolean updateCustomer(Customer c); 
	public boolean deleteCustomer(Customer c); 
}
