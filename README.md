# Overview
    You want to send your friend a package with different things.  
    Each thing you put inside the package has such parameters as index number, weight and cost. The package has a weight limit. Your goal is to determine which things to put into the package so that the total weight is less than or equal to the package limit and the total cost is as large as possible.  
    You would prefer to send a package which weighs less in case there is more than one package with the same price. 

    ## Input sample 
    Your program should accept as its first argument a path to a filename. The input file contains several lines. Each line is one test case.  
    Each line contains the weight that the package can take (before the colon) and the list of things you need to choose. Each thing is enclosed in parentheses where the 1st number is a thing's index number, the 2nd is its weight and the 3rd is its cost.

## Development Roadmap
1. **Find Knapsack Algorithm** - Started the project looking for an algorithm to solve the given problem.
    1. Exists many ways to resolve the knapsack problem, for this project, The **Branch and Bound** Algorithm was chosen to find a possible solution using a combinatorial optimization.

1. **Select a Design Pattern** - Main Idea is separate the caller's responsibilities of the construction of a complex object from its representation.
    1. For creational patterns were implemented: *Builder* and *Factory*
    1. For structural patterns were implemented: *Facade* and *Composite*
    
1. **Test/Code begins**

## Structure
The java-doc is available in ['docs/apidocs/index.html'](docs/apidocs/index.html)
UMLs is available in ['docs/diagramdocs'](docs/diagramdocs)

Main classes hierarchy are:

- [Caller](#caller) 
    - For this solution our caller (Packer.java) will call the **[Reader]** and **[Resolver]**.
    
    - [Reader](#reader) 
       - The Reader encapsulates the parsing and also call the validator for input. The Builder hierarchy makes possible the polymorphic creation of many peculiar representations.

     - [Validator](#validator) 
          - A processor that checks a *Line* from text document against contraints:
              1. Max weight that a package can take is ≤ 100 
              1. There might be up to 15 items you need to choose from 
              1. Max weight and cost of an item is ≤ 100 

     - [Resolver](#resolver)
            - This interface represents an "intermediate context". The Resolver contains a method that are implemented by contexts which can act as intermediate contexts for resolution purposes.

## Future improvements
 
 1. Make **Resolver** more flexible so that the developer can decide which algorithm to use and this way specialized solver for knapsack problems.
   1. Remove Constant's class and add a __property__ file to manage that.
    
## Prerequisite

- [Tools]
  - [Java 8]
  - [Maven 3.5]
  
## How to build it
1. Build the application using 
`mvn clean install`

2. Import the project as Maven

## How to Test
1. The uni-tests are implemented and you can run all the tests using
`mvn test`

## How to use this API

This KnapsackSolver java library can be plugs into your application spicing up your solution.

```java
import com.mobiquityinc.packer.Packer;

...
        String pack = Packer.pack("inputSample.txt");
        System.out.println(pack);
...
```

## Input file format
Input file can consist of multiple lines in format like this:
```
81 : (1,53.38,€45) (2,88.62,€98) (3,78.48,€3) (4,72.30,€76) (5,30.18,€9) (6,46.34,€48)
```

#### Output Sample
Output sample
For each set of things that you put into a package provide a new row in the output string (items’ index numbers are separated by comma). E.g.
```$xslt
4 
- 
2,7 
8,9
```

## Author

* **Mario Ponciano** - [LinkedIn](https://www.linkedin.com/in/marioponciano/)
 
