package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalGroupNameTest{

    AnimalGroupName animalGroupName = new AnimalGroupName();

    @Before
    public void setUp(){
        animalGroupName = new AnimalGroupName();
    }

    @Test
    public void getHerd_Should_ReturnMapKey_givenMapValue_FromAnimalsMap() {

        // arrange
        String animalNameDog = "dog";
        String expectedDog = "Pack";
        String animalNameCrow = "crow";
        String expectedCrow = "Murder";
        String animalNamePigeon = "pigeon";
        String expectedPigeon = "Kit";

        // act
        String actualDog = animalGroupName.getHerd(animalNameDog);
        String actualCrow = animalGroupName.getHerd(animalNameCrow);
        String actualPigeon = animalGroupName.getHerd(animalNamePigeon);

        // assert
        assertEquals("Because animals map key should return its set value- (dog, Pack)", expectedDog, actualDog);
        assertEquals("Because animals map key should return its set value- (crow, Murder)", expectedCrow, actualCrow);
        assertEquals("Because animals map key should return its set value- (pigeon, Kit)", expectedPigeon, actualPigeon);
    }

    @Test
    public void getHerd_Should_ReturnPack_givenDogAllUpperCase() {

        // arrange
        String animalName = "DOG";
        String expected = "Pack";

        // act
        String actual = animalGroupName.getHerd(animalName);

        // assert
        assertEquals("Because animal name should be converted to lowercase before processing data", expected, actual);
    }

    @Test
    public void getHerd_Should_ReturnPack_givenDogAllLowerCase() {

        // arrange
        String animalName = "dog";
        String expected = "Pack";

        // act
        String actual = animalGroupName.getHerd(animalName);

        // assert
        assertEquals("Because animal name should be converted to lowercase before processing data", expected, actual);
    }

    @Test
    public void getHerd_Should_ReturnUnknown_givenEmptyString() {

        // arrange
        String animalName = "";
        String expected = "unknown";

        // act
        String actual = animalGroupName.getHerd(animalName);

        // assert
        assertEquals("Because passing empty string as argument should return the string unknown", expected, actual);
    }

    @Test
    public void getHerd_Should_ReturnUnknown_givenNull() {

        // arrange
        String animalName = null;
        String expected = "unknown";

        // act
        String actual = animalGroupName.getHerd(animalName);

        // assert
        assertEquals("Because passing null value as argument should return the string unknown", expected, actual);
    }

    @Test
    public void getHerd_Should_ReturnUnknown_givenAnimalNotInMap() {

        // arrange
        String animalName = "monkey";
        String expected = "unknown";

        // act
        String actual = animalGroupName.getHerd(animalName);

        // assert
        assertEquals("Because passing an animal not in the map as argument should return the string unknown", expected, actual);

    }

    @Test
    public void getHerd_Should_ReturnCrash_givenRhino_firstElementAddedToMap() {

        // arrange
        String animalName = "Rhino";
        String expected = "Crash";

        // act
        String actual = animalGroupName.getHerd(animalName);

        // assert
        assertEquals("Because passing (first) animal key as argument should return it's value from map", expected, actual);
    }

    @Test
    public void getHerd_Should_ReturnFloat_givenCrocodile_lastElementAddedToMap() {

        // arrange
        String animalName = "Crocodile";
        String expected = "Float";

        // act
        String actual = animalGroupName.getHerd(animalName);

        // assert
        assertEquals("Because passing (last) animal key as argument should return it's value from map", expected, actual);
    }
}
