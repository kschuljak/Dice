package com.techelevator.farm.models;

public interface FarmableAnimal
{
    String getName();
    String getSound();
}

/*
VS abstract class FarmAnimal

-interface is only the contract (each class needs to implement the code separately)
(by default an interface cannot have any code, only abstract methods)
-abstract class allows for shared implementation code

 */
