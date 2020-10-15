package com.example.microservice.service;

import com.example.microservice.dto.LanguagesTrendsResponse;
import com.example.microservice.utills.Date;
import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;


//@RunWith(SpringRunner.class)
//@EnableConfigurationProperties
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GithubServiceImplTest {

//    @Autowired
//    private GithubService githubService ;
//
//    @Autowired
//    CacheManager cacheManager ;
//


    @Test
    void getLanguagesTrendByCache() throws InterruptedException {
//        String date = Date.currentDateMinusThirtyDays() ;
//        LanguagesTrendsResponse response = githubService.getLanguagesTrendsByCache(date) ;
//        assertEquals(response, githubService.getLanguagesTrendsByCache(date));
//        assertNotEquals(null, cacheManager.getCache("languages").get(date));
//        assertNotEquals(0, cacheManager);
    }

    @Test
    void getLanguagesTrendWithoutCache() throws InterruptedException {
//        String date = Date.currentDateMinusThirtyDays() ;
//        LanguagesTrendsResponse response = githubService.getLanguagesTrendsNotPassingByCache(date) ;
//        assertNotEquals(response, githubService.getLanguagesTrendsNotPassingByCache(date) );
//        assertNotEquals(null, cacheManager.getCache("languages").get(date));
    }

    @Test
    void getLanguageTrendByDate() throws InterruptedException {
//        String date = Date.currentDateMinusThirtyDays() ;
//        LanguagesTrendsResponse response = githubService.getLanguagesTrendsByDate(date) ;
//        assertEquals(true, response.getItems().size()>0);
    }
}
