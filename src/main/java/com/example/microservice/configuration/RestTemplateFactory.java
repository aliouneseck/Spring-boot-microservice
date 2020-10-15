package com.example.microservice.configuration;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class RestTemplateFactory implements FactoryBean<RestTemplate>, InitializingBean {

    private RestTemplate restTemplate;

    @Value("${githubApi.username}")
    private String gitubApiUsername ;
    @Value("${githubApi.password}")
    private String getGitubApiPassword ;

    public RestTemplate getObject() {
        return restTemplate;
    }
    public Class<RestTemplate> getObjectType() {
        return RestTemplate.class;
    }
    public boolean isSingleton() {
        return true;
    }

    public void afterPropertiesSet() {
        restTemplate = new RestTemplateBuilder().
                basicAuthentication(gitubApiUsername, getGitubApiPassword).build();

    }

}
