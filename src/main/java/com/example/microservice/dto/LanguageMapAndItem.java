package com.example.microservice.dto;


import lombok.Data;

import java.util.Map;

@Data
public class LanguageMapAndItem {
    private Item item ;
    private Map<String, Integer> languageURLResponse ;

    public LanguageMapAndItem(Item item, Map<String, Integer> languageURLResponse) {
        this.item = item;
        this.languageURLResponse = languageURLResponse;
    }
}
