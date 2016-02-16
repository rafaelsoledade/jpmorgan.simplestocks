## Motivation

This project is a simple stocks manager. It includes the use of several Java and OOP concepts such as inheritance, interfaces, abstract classes, generic types, static methods, amongst others. It also has a unitary test component.
The project was developed in Java using the Eclipse IDE, and it's a Maven project. The libraries used are Jackson and Google's JSON-Simple, used for deserializing a JSON file with a test data array.
The project was compiled using Java 8.

## Project Description

##### Requirements

1.	Provide working source code that will, for a given stock::
        
                a.	
                        i. Given a market price as input, calculate the dividend yield
                        ii. Given a market price as input,  calculate the P/E Ratio
                        iii. Record a trade, with timestamp, quantity of shares, buy or sell indicator and trade price
                        iv. Calculate Volume Weighted Stock Price based on trades in past 15 minutes

                b.	Calculate the GBCE All Share Index using the geometric mean of prices for all stocks

##### Constraints & Notes

1.	Written in one of these languages:
    
    * Java, C#, C++, Python.
    
2.	No database or GUI is required, all data need only be held in memory.

3.	Formulas and data provided are simplified representations for the purpose of this exercise.

## How To Run

After pulling the project from GitHub, you can compile it using mvn with the following command

     mvn clean install

To run the program as a Java application use the command

     mvn exec:java

## Program Interface

When running the project all the operations will be calculated for a set of pre-defined parameters. The results will be displayed on screen. Even though this part was not really specified in the exercise, a web service invocation approach could be developed in a future release using, for example, Spring annotations to request a REST WS with some given parameters that calls a Stock operation and returns the intended result.


## Tests

The project has a unit test component, implemented with JUnit 4. To run the tests, use the command

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
