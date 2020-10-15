package com.example.microservice.dto;


import lombok.Data;

@Data
public class Repo {

    int id ;
    String url ;

    public Repo() {
    }
    public Repo(Item item) {
        this.id = item.getId();
        this.url = item.getUrl();
    }
}
