package com.vcs;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Customer {
	private String name;
	
	
	private String userName;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int customerKey;
	
	private String password;
	private String address;
	private String state;
	private String country;
	private String pan;
	private String email;
	private long phoneNo;
	private LocalDate dob;
	private String accountType;
	
	public Customer() {
		super();
	}

	public Customer(String name, String userName, String password, String address, String state,
			String country, String pan, String email, long phoneNo, LocalDate dob, String accountType) {
		super();
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.address = address;
		this.state = state;
		this.country = country;
		this.pan = pan;
		this.email = email;
		this.phoneNo = phoneNo;
		this.dob = dob;
		this.accountType = accountType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getCustomerKey() {
		return customerKey;
	}

	public void setCustomerKey(int customerKey) {
		this.customerKey = customerKey;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", userName=" + userName + ", customerKey=" + customerKey + ", password="
				+ password + ", address=" + address + ", state=" + state + ", country=" + country + ", pan=" + pan
				+ ", email=" + email + ", phoneNo=" + phoneNo + ", dob=" + dob + ", accountType=" + accountType + "]";
	}
	
	
	
	
	
		
	
	
}
