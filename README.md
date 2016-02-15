## Motivation

This project is a simple stocks manager, developed as part of an assignment for a recruitment process @ JP Morgan. This software includes the use of several Java and OOP concepts such as inheritance, interfaces, abstract classes, generic types, static methods, amongst others. It also has a unitary test component.

## Project Description

##### Requirements

1.	Provide working source code that will:

    a.	For a given stock:
    
        i.    Calculate the dividend yield.
        ii.   Calculate the P/E Ratio.
        iii.  Record a trade, with timestamp, quantity of shares, buy or sell indicator and price.
        iv.   Calculate Stock Price based on trades recorded in past 15 minutes.

    b.	Calculate the GBCE All Share Index using the geometric mean of prices for all stocks

##### Constraints & Notes

1.	Written in one of these languages:
    
    * Java, C#, C++, Python.
    
2.	No database or GUI is required, all data need only be held in memory.

3.	Formulas and data provided are simplified representations for the purpose of this exercise.

## Installation

The project was developed in Java using the Eclipse IDE, in a Maven project. After getting the projet from GitHub, you can compile it using the command

     maven clean install

To run the program as a Java application use the command

     maven exec:java

## API Reference

The libraries used are Jackson and Google's JSON-Simple, used for deserializing a JSON file with a test data array.
The project was compiled using Java 8.

## Tests

The project has a unit test component, implemented with JUnit 4. To run the tests, use the command

     maven test

Sample test data:

##### Global Beverage Corporation Exchange

Stock Symbol  | Type | Last Dividend | Fixed Dividend | Par Value
------------- | ---- | ------------: | :------------: | --------: 
TEA           | Common    | 0  |    | 100
POP           | Common    | 8  |    | 100
ALE           | Common    | 23 |    | 60
GIN           | Preferred | 8  | 2% | 100
JOE           | Common    | 13 |    | 250
