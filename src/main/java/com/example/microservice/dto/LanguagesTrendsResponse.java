package com.example.microservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.apache.catalina.LifecycleState;
import org.springframework.scheduling.annotation.Async;

import java.util.*;

@Data
public class LanguagesTrendsResponse {



    @JsonProperty("total_count")
    private int totalCounts ;

    @JsonProperty("date")
    private Date date ;

    @JsonProperty("items")
    private List<Language> items ;

    @JsonIgnore // We don't send it to client.
    private Map<String, Language> languageMap ;


    public LanguagesTrendsResponse() {

        this.languageMap = new HashMap<String, Language>() ;
    }


    public void add(LanguageMapAndItem languageMapAndItem) {
        Repo newRepo = new Repo(languageMapAndItem.getItem());
        for (Object languageName : languageMapAndItem.getLanguageURLResponse().keySet()) {
            languageMap.computeIfPresent((String) languageName, (key, language) ->{
                language.incrementNumber();
                language.addRepo(newRepo);
                language.incrementByteCode(languageMapAndItem.getLanguageURLResponse().get(languageName));
                return language;
            } );
            languageMap.computeIfAbsent((String) languageName,  key -> {
                Language newLanguage = new Language();
                newLanguage.setName((String) languageName);
                newLanguage.addRepo(newRepo);
                newLanguage.incrementByteCode(languageMapAndItem.getLanguageURLResponse().get(languageName));
                return newLanguage ;
            }) ;


        }
    }

    public void finalizeFormating() {
        this.items = new ArrayList(this.languageMap.values()) ;
        Collections.sort(items, Collections.reverseOrder());
        this.totalCounts = this.items.size() ;
        this.date = new Date() ;
    }


}
