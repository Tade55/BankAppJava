package com.example.demo.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.Repo.CustomerRepo;

@Component
public class CustomerSupport {
	@Autowired
	CustomerRepo repo;
	
    private List<Customer> findAllCustomer(){
        
		return repo.findAll();
    }
    
    public long generateAccountNumber() {
    var accountNumber=(long)(10_000_000_000L*Math.random());	
    for(var customer:findAllCustomer()) {
    	if(accountNumber==customer.getAccountNumber())
    		generateAccountNumber();
    }
    return accountNumber;
    }
}
