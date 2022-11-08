package com.techelevator.farm.models;

public interface Singable
{
    // cannot make private methods in an interface
    // everything in an interface, by definition, is public
    String getName();
    String getSound();
}
