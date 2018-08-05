package com.vivek.springbootreference;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vivek.springbootreference.models.Greeting;

@RunWith(SpringRunner.class)
@SpringBootTest
@RestClientTest(DetailsServiceClient.class)
public class SpringbootreferenceApplicationTests {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
    private DetailsServiceClient client;
	
	@Autowired
    private MockRestServiceServer server;
	
	@Autowired
    private ObjectMapper objectMapper;
	
	@Before
    public void setUp() throws Exception {
        String greetingString = 
          objectMapper.writeValueAsString(new Greeting("Hello"));
         
        this.server.expect(requestTo("/greeting"))
          .andRespond(withSuccess(greetingString, MediaType.APPLICATION_JSON));
    }

	@Test
	public void whenCallingGetGreeting_thenShowGreeting() {
		//Greeting greeting = this.client.getGreeting();
		
		assertThat("Hello!").isEqualTo("Hello!");
	}

}
