package com.example.microservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Language implements Comparable<Language> {

    String name ;

    @JsonProperty("number_of_repos")
    int number ;
    @JsonProperty("byte_code")
    Float byteCode ;
    @JsonProperty("repo_list")
    List<Repo> repoList;



    public Language() {
        number = 1 ;
        repoList = new ArrayList() ;
        byteCode = 0f ;
    }
    public void incrementNumber(){

        number ++ ;
    }
    public void incrementByteCode (Integer d){
        this.byteCode += d;
    }

    public void addRepo (Repo newRepo){
        repoList.add(newRepo) ;
    }

    @Override
    public int compareTo(Language l) {
        return this.number - l.getNumber();
    }
}
