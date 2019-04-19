package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.model.Customer;

@Repository
public class CustomerDao {

	private static List<Customer> customers;
	
	{
		customers=new ArrayList();
		customers.add(new Customer(101,"John","Doe"));
		customers.add(new Customer(102,"Jane","Dee"));
		customers.add(new Customer(103,"Philippe","Plein"));
		

	}
	
	public Customer getCustomerById(int id) {
		Customer match = null;
		
		for(Customer c : customers) {
			if(c.getId()==id) {
				match=c;
				break;
			}
		}
		
		return match;
	}
	
	public List<Customer> getAllCustomers(){
		return customers;
	}
	
	public Customer createCustomer(Customer customer) {
		customers.add(customer);
		
		return customers.get(customers.size()-1);
	}
	
	public Customer updateCustomer(int id, Customer customer) {
		
		for(Customer c : customers) {
			if(c.getId()==id) {
				customer.setId(c.getId());
				customers.remove(c);
				customers.add(customer);
				return customer;
				
			}
		}
		
		return null;
		
		
	}
	
	public Customer delete(int id) {
		for(Customer c : customers) {
			if(c.getId()==id) {
				customers.remove(c);
				return c;
			}
		}
		
		return null;
	}
}
