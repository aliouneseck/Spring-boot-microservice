# Presentation

We developed REST microservice  with Spring boot. It lists the languages used by the 100 trending  public repositories on GitHub in the past 30 days. For each language we have:
* The name of the language
* The number of repositories using this language
* The number of bytes of code written in that language
* The list of repositories that use it

## Installation Instructions

You can import the project as a maven application to your favorite IDE. This project was developped t by using itellij IDEA utilmate 2019.

If you use Eclipse, lombok may gets in your way, by referring this [answer](https://stackoverflow.com/questions/22310414/how-to-configure-lombok-in-eclipse-luna/22332248#22332248), you can install lombok by its jar file.

## Run the application
Use one of the several ways of running a Spring Boot application. Below are just three options:

* Build using maven goal (or by using maven wrapper): `mvn clean` package and execute the resulting artifact as follows ` java -jar microservice-0.0.1-SNAPSHOT.jar ` or
* On Unix/Linux based systems: run ` mvn clean ` then run the resulting jar as any other executable `./microservice-0.0.1-SNAPSHOT.jar `
* Run as a Docker container: 

  1. Clone the repository. <br/>
  2. Go to the root of the project <br/>
  3. Build a jar
  4. Build an image : `docker build -t microservice`. <br/>
  5. Run the image : `docker run --expose 8080 -p 8080:8080 microservice`

## Usage

After running the code, you can test the main features by requesting these two URL:


 1. 
 ``` 
 curl http://localhost:8080/languages_trends
 ```
 Typically, you should wait 3-10 seconds for the server to return the results below:

 ```
{
  "total_count" : 84,
  "date" : "2020-10-14T18:33:41.314+00:00",
  "items" : [ {
    "name" : "Python",
    "number_of_repos" : 35,
    "byte_code" : 1.1135904E7,
    "repo_list" : [ {
      "id" : 300592907,
      "url" : "https://api.github.com/repos/mxrch/GHunt"
    }, {
      "id" : 300996055,
      "url" : "https://api.github.com/repos/lucidrains/vit-pytorch"
    }, {
      "id" : 296415674,
      "url" : "https://api.github.com/repos/NVIDIA/libcudacxx"
    }, {
      "id" : 298459151,
      "url" : "https://api.github.com/repos/genforce/genforce"
    }, {
      "id" : 297012185,
      "url" : "https://api.github.com/repos/CppCon/CppCon2020"
    }, {
      "id" : 298887968,
      "url" : "https://api.github.com/repos/rvizzz/rotate"
    }, {
      "id" : 299329204,
      "url" : "https://api.github.com/repos/sukritishah15/DS-Algo-Point"
    ......
    ......
    ......

 ```
If you want a quick result, you can use the cache:

 2. 
 ``` 
 curl http://localhost:8080/languages_trends/cache
 ```
Usually you will have the same result as above. This result was given by the cache which recorded the results of the previous query with the date as key. This is the reason why we have a quick response.


We have a container running on Heroku for free. It may be little slow because the application is unused for a while it gets unloaded by Heroku.
You can request it at this adresse: https://my-microservice-springboot.herokuapp.com/languages_trends/cache. 


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

If you want more information about the code you can read the wiki: https://github.com/aliouneseck/Spring-boot-microservice/wiki


