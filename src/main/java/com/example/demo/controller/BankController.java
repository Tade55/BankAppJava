package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repo.CustomerRepo;
import com.example.demo.dao.Customer;
import com.example.demo.dao.CustomerSupport;
@RestController
public class BankController {
	@Autowired
	CustomerRepo repo;
	
	@Autowired
	CustomerSupport support;
    
	@PostMapping("/")
	public void createCustomer(@RequestBody Customer customer) {
		customer.setAccountNumber(support.generateAccountNumber());
		repo.save(customer);	
	}
	
	@GetMapping("/getCustomer")
	public List<Customer> getCustomer() {
		return repo.findAll();
	}
}
