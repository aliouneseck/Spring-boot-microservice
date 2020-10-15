package com.example.microservice.service;
import com.example.microservice.dto.*;
import com.example.microservice.utills.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;


import java.util.*;
import java.util.concurrent.*;

@Service
public class GithubServiceImpl implements GithubService {

@Autowired
RestTemplate restTemplate ;

@Autowired
CacheManager cacheManager ;

@Value("${githubApi.username}")
private String gitubApiusername ;
@Value("${githubApi.password}")
private String getGitubApiPassword ;
@Value("${githubApi.URL}")
private String getGitubApiURL ;





    @Override
    @Cacheable(value = "languages")
    public LanguagesTrendsResponse getLanguagesTrendsByCache(String date) throws InterruptedException {
        return getLanguagesTrendsByDate(date) ;
    }

    @Override
    public LanguagesTrendsResponse getLanguagesTrendsNotPassingByCache(String date) throws InterruptedException {
        LanguagesTrendsResponse response =  getLanguagesTrendsByDate(date) ;

        // update the cache
        clearCache();
        addToCache(date, response);

        return response ;

    }

    @Override
    public LanguagesTrendsResponse getLanguagesTrendsByDate(String date) throws InterruptedException {
//
        String url = String.format(getGitubApiURL, date) ;
        LanguagesTrendsResponse languagesTrendsResponse = new LanguagesTrendsResponse() ;
        GithubAPIResponse githubAPIResponse= restTemplate.getForObject(url, GithubAPIResponse.class);
        List<Item> items = githubAPIResponse.getItems() ;


        CountDownLatch latch = new CountDownLatch(items.size()) ;

        Flux.fromIterable(items)
                .parallel()
                .runOn(Schedulers.elastic())
                .flatMap(this::get)
                .subscribe(languageMapAndItem -> {
                    languagesTrendsResponse.add(languageMapAndItem);
                    latch.countDown();
        }) ;
        // wait all the parallell calls finish
        latch.await();
        languagesTrendsResponse.finalizeFormating();
        clearCache();// clean the cache
        return languagesTrendsResponse;
    }


    private Mono<LanguageMapAndItem> get (Item item) {

        return WebClient.create()
                .get()
                .uri(item.getLanguages_url())
                .headers(headers -> headers.setBasicAuth(gitubApiusername, getGitubApiPassword))
                .retrieve()
                .bodyToMono(Map.class)
                .map(languageURLResponse -> new LanguageMapAndItem(item,languageURLResponse) );

    }

    private void clearCache(){
        cacheManager.getCache("languages").clear();
    }

    private void addToCache (String date, LanguagesTrendsResponse response) {
        cacheManager.getCache("languages").put(date, response );
    }


    // Scduled task for updating the cache
    // Update every day at 0:12
    @Scheduled(cron = "0 12 0 * * ?")
    public void scheduleTask() {
        try {
            getLanguagesTrendsNotPassingByCache(Date.currentDateMinusThirtyDays()) ;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

