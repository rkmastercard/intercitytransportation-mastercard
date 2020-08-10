# InterCityTransportationApplication

###### Overview
This application provides information if two cities are connected.
 
###### Build application

```
git clone https://github.com/rkmastercard/intercitytraspotation-mastercard.git
mvn clean test
mvn spring-boot:run
``` 
 
###### Tech/Framework used
- Java 8
- SpringBoot 2.3.1
- Maven
- Mockito
- JUnit
 
###### Features
This program reads input (source city and destination city) from given text file and store all the data in Set.
It will create disjoint set in case 2 cities are not present in previous set of cities.

Application will return ‘yes’ if city1 is connected to city2, ’no’ if city1 is not connected to city2.
Any unexpected input should result in a ’no’ response. 
 
###### Endpoint - test in postman

 http://localhost:8080/connected/cities?origin=city1&destination=city2

 Unit Testing
 
 Unit testing carried through Mockito framework, allows the creation of unit tests for the purpose of test-driven development (TDD). 
 Test cases are cover Only controller class for this project. Unit Test classes can run through maven build command or can be execute 
 directly from test class from Spring Tool Suite(STS).
 
##  />mvn clean install
all the test cases passed.