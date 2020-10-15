package com.example.microservice.service;

import com.example.microservice.dto.LanguagesTrendsResponse;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface GithubService {


     LanguagesTrendsResponse getLanguagesTrendsByDate(String date) throws InterruptedException;
     LanguagesTrendsResponse getLanguagesTrendsByCache(String date) throws InterruptedException;
     LanguagesTrendsResponse getLanguagesTrendsNotPassingByCache(String date) throws InterruptedException;



}
