package com.aztec.airport.controller;

import com.aztec.airport.application.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Controller integration test.
 *
 * @author robertgolder
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringApplicationConfiguration(classes={Application.class})
@IntegrationTest({"server.port=8080"})
public class AeroplaneControllerIntegrationTest {

    private RestTemplate restTemplate;

    @Before
    public void setup() {
        restTemplate = new TestRestTemplate();
    }

    @Test
    public void testList() throws Exception {
        ResponseEntity<String> entity = restTemplate.getForEntity("http://localhost:8080/aeroplane/list/222abc", String.class);
        assertThat(entity.getStatusCode(), is(HttpStatus.OK));
        assertThat(entity.toString().contains("View Aeroplanes"), is(true));
    }

    @Test
    public void testRetrieve() throws Exception {
        ResponseEntity<String> entity = restTemplate.getForEntity("http://localhost:8080/aeroplane/IJ12 ABC", String.class);
        assertThat(entity.getStatusCode(), is(HttpStatus.OK));
        assertThat(entity.toString().contains("View Aeroplane"), is(true));
    }
}
