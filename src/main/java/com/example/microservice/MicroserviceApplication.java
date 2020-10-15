package com.example.microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MicroserviceApplication implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(MicroserviceApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {


//    githubServiceCachable.getLanguageTrends() ;



    }
}
