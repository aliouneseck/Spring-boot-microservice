package com.example.microservice.controller;

import com.example.microservice.dto.LanguagesTrendsResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;



@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GithubControllerTest {


    @LocalServerPort
            private int port ;
    @Autowired
    private TestRestTemplate restTemplate ;


    @Test
    void getLanguagesTrends() {

        LanguagesTrendsResponse response =  this.restTemplate
                .getForObject("http://localhost:" + port + "/languages_trends", LanguagesTrendsResponse.class ) ;
        assertNotEquals(null, response);
        assertEquals(true, response.getItems().size()>0);
    }

    @Test
    void getLanguagesTrendsByCache() {
    }
}
