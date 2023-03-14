package com.phcodegyan.H2DatabseSetup;

import com.phcodegyan.H2DatabseSetup.db.Age;
import com.phcodegyan.H2DatabseSetup.servises.Servise;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class H2DatabseSetupApplicationTests {


	@Autowired
	private Servise servise;
	String ageResult, ageExpected;

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void shouldPassIfStringMatches() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/", String.class)).contains("Hello World from Spring Boot");
	}

	@Test
	public void sendRequestResultIsJson() throws IOException {
		SpringApplication.run(H2DatabseSetupApplication.class);

		String jsonMimeType = "application/json";
		HttpUriRequest request = new HttpGet( "http://localhost:8080/find/1" );
		HttpResponse response = HttpClientBuilder.create().build().execute( request );
		String mimeType = ContentType.getOrDefault(response.getEntity()).getMimeType();
		assertEquals( jsonMimeType, mimeType );
	}

	@Test
	public void nameEquals() {
		List<Age> people = servise.baseAge(2l);
		List<Age> ageList = new ArrayList<>(List.of(new Age("Alex",20L,2l)));
		people.forEach(person -> {ageResult = person.getName();});
		ageList.forEach(person -> {ageExpected = person.getName();});
		assertEquals(ageExpected,ageResult);
	}
}
