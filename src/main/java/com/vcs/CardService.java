package com.vcs;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {
	
	@Autowired
	private CardsRepository repo;
	
	public Card getCard(int customerKey){
		return repo.findAll().stream().filter(card -> card.getCustomerKey() == customerKey).collect(Collectors.toList()).get(0);
	}
	
}
