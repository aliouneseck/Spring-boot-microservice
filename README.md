# Presentation

We developed REST microservice  with Spring boot. It lists the languages used by the 100 most common public repositories on GitHub in the past 30 days. For each language we have:
* The name of the language
* The number of repositories using this language
* The number of bytes of code written in that language
* The list of repositories that use it

## Installation Instructions

You can import the project as a maven application to your favorite IDE. This project was developped t by using itellij IDEA utilmate 2019.

If you use Eclipse, lombok may gets in your way, by referring this answer, you can install lombok by its jar file.

## Run the application
Use one of the several ways of running a Spring Boot application. Below are just three options:

* Build using maven goal (or by using maven wrapper): `mvn clean` package and execute the resulting artifact as follows ` java -jar microservice-0.0.1-SNAPSHOT.jar ` or
* On Unix/Linux based systems: run ` mvn clean ` then run the resulting jar as any other executable `./microservice-0.0.1-SNAPSHOT.jar `
* Run as a Docker container: 

  1. Clone the repository. <br/>
  2. Go to the root of the project <br/>
  3. `docker build -t microservice`. <br/>
`docker run --expose 8080 -p 8080:8080 demo/microservice`

## Usage

After running the code, you can test the main features by requesting these two URL:


 1. 
 ``` 
 curl http://localhost:8080/languages_trends
 ```
 Usually you have to wait 2 to 6 seconds for the server to process the results below:

 ```
 {
  "total_count" : 62,
  "date" : "2020-10-13T00:39:27.375+00:00",
  "items" : [ {
    "name" : "Python",
    "number_of_repos" : 34,
    "repo_list" : [ {
      "id" : 299644773,
      "url" : "https://api.github.com/repos/EssayKillerBrain/EssayKiller_V2"
    }, {
      "id" : 297012185,
      "url" : "https://api.github.com/repos/CppCon/CppCon2020"
    }, {
      "id" : 300592907,
      "url" : "https://api.github.com/repos/mxrch/GHunt"
    }, {
      "id" : 296415674,
      "url" : "https://api.github.com/repos/NVIDIA/libcudacxx"
    }, {
      "id" : 297672263,
      "url" : "https://api.github.com/repos/MaartenGr/BERTopic"
    ......
    ......
    ......

 ```
If you want a quick result, you can use the cache:

 2. 
 ``` 
 curl http://localhost:8080/languages_trends/cache
 ```
Usually you will have the same result as below. This result was given by the cache that saved the results of previous request. That's the reason we have a quick response.

We have a container running on Heroku. You can request it on this adresse: [here](https://my-microservice-springboot.herokuapp.com/languages_trends/cache)


## Dependencies

The list of dependencies we use for this project:

* spring-boot-starter-web
* spring-boot-devtools
* lombok
* spring-boot-starter-test
* junit-vintage-engin
* commons-codec
* httpclient
* reactor-spring
* spring-boot-starter-cache
* spring-boot-starter-aop

## Code Documentation

If you want more information you can read the wiki: https://github.com/aliouneseck/Spring-boot-microservice/wiki


