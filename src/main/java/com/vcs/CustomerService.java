package com.vcs;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerDao customerDao;
	
	public List<Customer> getAllCustomers(){
		return customerDao.getAllCustomers();
	}
	
	public void saveCustomer(Customer customer) {
		customerDao.saveCustomerToDatabase(customer);
	}

	public Boolean testUser(String userName, String password) {
		int size = customerDao.getAllCustomers().stream().filter(customer -> customer.getUserName().equals(userName) && customer.getPassword().equals(password)).collect(Collectors.toList()).size();
		if(size == 0) {
			return false;
		}
		return true;
	}

	public int getCustomerKey(String userName) {		
		return customerDao.getAllCustomers().stream().filter(customer -> customer.getUserName().equals(userName)).collect(Collectors.toList()).get(0).getCustomerKey();
	}

	public Boolean userExists(String userName) {
		int size = customerDao.getAllCustomers().stream().filter(customer -> customer.getUserName().equals(userName)).collect(Collectors.toList()).size();
		if(size == 0) {
			return false;
		}
		return true;
	}
	
}
