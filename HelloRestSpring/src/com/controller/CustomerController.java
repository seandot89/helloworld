package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dao.CustomerDao;
import com.model.Customer;

@RestController
@RequestMapping("rest")
public class CustomerController {

	@Autowired
	CustomerDao dao;
	
	@GetMapping("/customers")
	public List<Customer> getCustomers(){
		return dao.getAllCustomers();
	}
	
	@GetMapping("/customer/{id}")
	public Customer getCustomerById(@PathVariable int id) {
		return dao.getCustomerById(id);
	}
	
	@PostMapping("/customer")
	public Customer createCustomer(@RequestBody Customer customer) {
		return dao.createCustomer(customer);
	}
	
	@DeleteMapping("/customer/delete/{id}")
	public Customer deleteCustomer(@PathVariable int id) {
		return dao.delete(id);
	}
}
