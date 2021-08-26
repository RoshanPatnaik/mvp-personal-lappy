package com.vcs;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Override 
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<Customer> customer = customerRepository.findByUserName(userName);
		
		//if user does not exists throw this userFriendlyMessage
		customer.orElseThrow(()->new UsernameNotFoundException("User does not exists with the name"+userName));
	return 	customer.map(MyUserDetails::new).get();
	}

}
