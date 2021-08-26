package com.vcs;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class CustomerDao{

	@Autowired
	private CustomerRepository repo;
	
	public List<Customer> getAllCustomers(){
		return repo.findAll();
		
	}
	
	public void saveCustomerToDatabase(Customer customer) {
		repo.save(customer);
	}
	
	public void removeCustomerFromDatabase(Customer customer) {
		repo.delete(customer);
	}
	
	public Customer getCustomer(Customer customer) {
		return repo.findById(customer.getCustomerKey()).get();
	}

}
