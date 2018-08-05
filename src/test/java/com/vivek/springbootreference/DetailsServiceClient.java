package com.vivek.springbootreference;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vivek.springbootreference.models.Greeting;
import com.vivek.springbootreference.models.Quote;

@Service
public class DetailsServiceClient{
	
	private final RestTemplate restTemplate;
	
	public DetailsServiceClient(RestTemplateBuilder builder) {
		restTemplate = builder.build();
	}
	
	public Greeting getGreeting() {
		return restTemplate.getForObject("/greeting", Greeting.class);
	}
	
	public Quote getQuote(){
		return restTemplate.getForObject("/quote", Quote.class);
	}
	
}