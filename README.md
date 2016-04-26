## Motivation

This project is a simple stocks manager. It includes the use of several Java and OOP concepts such as inheritance, interfaces, abstract classes, generic types, static methods, amongst others. It also has a unitary test component.
The project was developed in Java using the Eclipse IDE, and it's a Maven project. The libraries used are Jackson and Google's JSON-Simple, used for deserializing a JSON file with a test data array.
The project was compiled using Java 8.

## How To Run

After pulling the project from GitHub, you can compile it using mvn with the following command

     mvn clean install

To run the program as a Java application use the command

     mvn exec:java

## Program Interface

When running the project all the operations will be calculated for a set of pre-defined parameters. The results will be displayed on screen. Even though this part was not really specified in the exercise, a web service invocation approach could be developed in a future release using, for example, Spring annotations to request a REST WS with some given parameters that calls a Stock operation and returns the intended result.


## Tests

The project has a unit test component with a coverage of around 70%, implemented with JUnit 4. To run the tests, use the command

     mvn clean test

## Sample Test Data

##### Global Beverage Corporation Exchange

Stock Symbol  | Type | Last Dividend | Fixed Dividend | Par Value
------------- | ---- | ------------: | :------------: | --------: 
TEA           | Common    | 0  |    | 100
POP           | Common    | 8  |    | 100
ALE           | Common    | 23 |    | 60
GIN           | Preferred | 8  | 2% | 100
JOE           | Common    | 13 |    | 250
