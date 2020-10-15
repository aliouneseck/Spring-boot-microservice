package com.example.microservice.dto;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

//@RunWith(JUnit4.class)
class LanguagesTrendsResponseTest  {

    private LanguagesTrendsResponse trendsResponse = new LanguagesTrendsResponse() ;
    private LanguageMapAndItem mapAndItem1 ;
    private LanguageMapAndItem mapAndItem2 ;
    private LanguageMapAndItem mapAndItem3 ;
    private Map<String, Integer> LanguageURLResponse1 = new HashMap<>() ;
    private Map<String, Integer> LanguageURLResponse2 = new HashMap<>() ;
    private Map<String, Integer> LanguageURLResponse3 = new HashMap<>() ;
    private Item item1 = new Item();
    private Item item2= new Item();
    private Item item3= new Item();

    @BeforeEach
    public void initialize() {
        LanguageURLResponse1.put("Java", 34444) ;
        LanguageURLResponse1.put("C", 34444) ;
        LanguageURLResponse1.put("Python", 34444) ;
        LanguageURLResponse2.put("Perl", 34444) ;
        LanguageURLResponse2.put("JavaScript", 34444) ;
        LanguageURLResponse2.put("Python", 34444) ;
        LanguageURLResponse3.put("Python", 34444) ;
        LanguageURLResponse3.put("C", 34444) ;
        item1.setId(1);
        item1.setUrl("google.fr");
        item2.setId(2);
        item2.setUrl("google.fr");
        item3.setId(3);
        item3.setUrl("google.fr");
        mapAndItem1 = new LanguageMapAndItem(item1, LanguageURLResponse1) ;
        mapAndItem2 = new LanguageMapAndItem(item2, LanguageURLResponse2) ;
        mapAndItem3 = new LanguageMapAndItem(item3, LanguageURLResponse3) ;
        trendsResponse.add(mapAndItem1);
        trendsResponse.add(mapAndItem2);
        trendsResponse.add(mapAndItem3);

    }


    @AfterEach
    public void clean(){

    }

    @Test
    void add() {
        assertEquals(1, trendsResponse.getLanguageMap().get("Java").number);
        assertEquals(1, trendsResponse.getLanguageMap().get("JavaScript").number);
        assertEquals(3, trendsResponse.getLanguageMap().get("Python").number);
        assertEquals(2, trendsResponse.getLanguageMap().get("C").number);
        assertEquals(1, trendsResponse.getLanguageMap().get("Perl").number);
    }

    @Test
    void finalizeFormating() {
        trendsResponse.finalizeFormating();
        assertEquals(5, trendsResponse.getTotalCounts()) ;
        assertEquals(5, trendsResponse.getItems().size()) ;

    }
}
