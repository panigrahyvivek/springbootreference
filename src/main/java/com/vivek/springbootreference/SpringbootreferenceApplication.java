package com.vivek.springbootreference;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableScheduling
public class SpringbootreferenceApplication implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(SpringbootreferenceApplication.class);

	public static void main(String[] args) throws InterruptedException {
		ApplicationContext ctx = SpringApplication.run(SpringbootreferenceApplication.class, args);
		
		StringRedisTemplate template = ctx.getBean(StringRedisTemplate.class);
		CountDownLatch latch = ctx.getBean(CountDownLatch.class);
		
		log.info("Sending Message...");
		template.convertAndSend("chat", "Hello from Redis!");
		latch.await();
	}

	/*
	 * @Bean public RestTemplate restTemplate(RestTemplateBuilder builder) { return
	 * builder.build(); }
	 */

	/*
	 * @Bean public CommandLineRunner run(RestTemplate restTemplate) throws
	 * Exception { return args -> { Quote quote = restTemplate.getForObject(
	 * "http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
	 * log.info(quote.toString()); }; }
	 */

	@Autowired
	JdbcTemplate jdbcTemplate;


	@Override
	public void run(String... args) throws Exception {
		log.info("Creating Tables");
		jdbcTemplate.execute("DROP TABLE customers IF EXISTS");
		jdbcTemplate.execute("CREATE TABLE customers(" + "id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");

		List<Object[]> splitUpNames = Arrays.asList("John Woo", "Jeff Dean", "Josh Bloch", "Josh Long").stream()
				.map(name -> name.split(" ")).collect(Collectors.toList());

		splitUpNames.forEach(name -> log.info(String.format("Inserting customer record for %s %s", name[0], name[1])));

		jdbcTemplate.batchUpdate("INSERT INTO customers(first_name, last_name) VALUES (?,?)", splitUpNames);
		
		/*
		jdbcTemplate.query(
                "SELECT id, first_name, last_name FROM customers WHERE first_name = ?", new Object[] { "Josh" },
                (rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"))
        ).forEach(customer -> log.info(customer.toString()));
		*/
		
		
	};

}
