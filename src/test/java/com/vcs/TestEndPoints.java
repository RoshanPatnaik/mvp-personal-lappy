package com.vcs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
public class TestEndPoints {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private CardService cardService;
	
	@Test
	public void testGetEndPoint() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("http://localhost:8080/card");
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expected = "{accountNumber:123456789012,cvv:666,balance:10000,expiry:07/25,customerKey:1}";
		assertEquals(expected, result.getResponse());
	}
	
}
