package com.example.microservice.controller;

import com.example.microservice.dto.LanguagesTrendsResponse;
import com.example.microservice.logging.LogExecutionTime;
import com.example.microservice.service.GithubService;
import com.example.microservice.utills.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GithubController {


    @Autowired
    GithubService githubService ;

    @LogExecutionTime
    @GetMapping("/languages_trends")
    public ResponseEntity<LanguagesTrendsResponse> getLanguagesTrends() throws InterruptedException {
        return new ResponseEntity<>(githubService.getLanguagesTrendsNotPassingByCache(Date.currentDateMinusThirtyDays()), HttpStatus.OK);
    }


    @LogExecutionTime
    @GetMapping("/languages_trends/cache")
    public ResponseEntity<LanguagesTrendsResponse> getLanguagesTrendsByCache() throws InterruptedException {
        return new ResponseEntity<>(githubService.getLanguagesTrendsByCache(Date.currentDateMinusThirtyDays()), HttpStatus.OK);
    }
}
