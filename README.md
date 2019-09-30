## Roadmap
1. **Find Knapsack Algorithm** - Started the project looking for an algorithm to solve the given problem.
    1. Exists many ways to resolve the knapsack problem, for this project, The **Branch and Bound** Algorithm was chosen to find a possible solution using a combinatorial optimization.

1. **Select a Design Pattern** - Main Idea is separate the caller's responsibilities of the construction of a complex object from its representation.
    1. For creational patterns were: *Builder* and *Factory*
    1. For structural patterns was: *Facade* and *Composite*
    
1. **Code begins** 

## Structure

Main classes hierarcky are:

- [Caller](#caller) - For this solution our caller (Packer.java) will call the **[Reader]** and **[Resolver]**.
    - [Reader](#reader) - The Reader encapsulates the parsing of the common input. The Builder hierarchy makes possible the polymorphic creation of many peculiar representations or targets.
    - [Validator](#validator) 
    - [Resolver](#resolver)

## Prerequisite

- [Tools](#tools)
  - [Java 8](#java8)
  - [Maven 3.5](#maven)
  
## How to use it
1. Build the application using 
`mvn clean install`

2. Import the project as Maven

## Input file format
Input file can consist of multiple lines in format like this:
```
81 : (1,53.38,€45) (2,88.62,€98) (3,78.48,€3) (4,72.30,€76) (5,30.18,€9) (6,46.34,€48)
```

## Author

* **Mario Ponciano** - [LinkedIn](https://www.linkedin.com/in/marioponciano/)
 
