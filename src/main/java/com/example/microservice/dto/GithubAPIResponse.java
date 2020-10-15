package com.example.microservice.dto;

import lombok.Data;

import java.util.List;



@Data
public class GithubAPIResponse {
 List <Item> items ;

 public GithubAPIResponse(List<Item> items) {
  this.items = items;
 }
 public GithubAPIResponse() {

 }
}
