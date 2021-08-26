package com.vcs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Card {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 12)
	private long cardNumber;
	
	private int cvv;
	private double balance;
	private String expiry;
	private int customerKey;
	
	public Card() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Card(long cardNumber, int cvv, double balance, String expiry, int customerKey) {
		super();
		this.cardNumber = cardNumber;
		this.cvv = cvv;
		this.balance = balance;
		this.expiry = expiry;
		this.customerKey = customerKey;
	}

	public long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getExpiry() {
		return expiry;
	}

	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}

	public int getCustomerKey() {
		return customerKey;
	}

	public void setCustomerKey(int customerKey) {
		this.customerKey = customerKey;
	}

	@Override
	public String toString() {
		return "Card [cardNumber=" + cardNumber + ", cvv=" + cvv + ", balance=" + balance + ", expiry=" + expiry
				+ ", customerKey=" + customerKey + "]";
	}
	
	
	
	
	
}
