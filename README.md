# Sample Task to Implement non-blocking API

## Prerequisites to Run the Application
```
- java 11
- maven 3.3.X+
```

## How to Run the Application
1. go to the root folder of the project
2. execute `mvn clean package`
3. execute `java -jar target/asynchronous-rest-calls-0.0.1-SNAPSHOT.jar`
4. on browser open [http://localhost:9345/swagger-ui.html](http://localhost:9345/swagger-ui.html)

## Some Thoughts From the Author
```
- Webflux could be used as an alternative of CompetableFuture for non-blocking calls. Just an alternative.
- It's possible to have more advanced test cases. For example, we could use wiremock to mock external API endpoints, so we could exactly know what to expect as response and verify the data when testing with rest assured
```
