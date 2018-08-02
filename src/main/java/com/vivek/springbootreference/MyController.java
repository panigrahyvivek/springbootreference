package com.vivek.springbootreference;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.vivek.springbootreference.models.Customer;
import com.vivek.springbootreference.models.Greeting;
import com.vivek.springbootreference.models.Quote;

@RestController
public class MyController {
	
	
	private static final Logger log = LoggerFactory.getLogger(MyController.class);
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	private final JdbcTemplate jdbcTemplate;
	
	
	public MyController(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	
	@RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
		Greeting greeting = new Greeting( String.format(template, name)); 
        greeting.add(linkTo(methodOn(MyController.class).greeting(name)).withSelfRel());
		return greeting;
    }
	
	@RequestMapping("/quote")
    public Quote quote() {
		RestTemplate restTemplate = new RestTemplate();
		Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
		log.info(quote.toString());
		return quote;
    }
	
	@RequestMapping("/customers")
	@Transactional
    public Customer getCustomers() {
		log.info("Querying for customer records where first_name = 'Josh':");

		return jdbcTemplate.queryForObject("SELECT id, first_name, last_name FROM customers WHERE first_name = ?",
				new Object[] { "Jeff" },
				(rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name")));
				
    }
	
	
}