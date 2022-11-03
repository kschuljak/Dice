package com.techelevator;

public class FruitTree {

    // instance variables
    private String typeOfFruit;
    private int piecesOfFruitLeft;

    // type of fruit - getter
    public String getTypeOfFruit() {
        return typeOfFruit;
    }

    // pieces of fruit left - getter
    public int getPiecesOfFruitLeft() {
        return piecesOfFruitLeft;
    }

    // constructor


    public FruitTree(String typeOfFruit, int piecesOfFruitLeft) {
        this.typeOfFruit = typeOfFruit;
        this.piecesOfFruitLeft = piecesOfFruitLeft;
    }

    // method - pick fruit
    // input - int number of pieces to remove
    // return - boolean (pieces to remove <= remaining fruit)
    public boolean pickFruit(int numberOfPiecesToRemove) {
        boolean isEnoughLeft = (piecesOfFruitLeft - numberOfPiecesToRemove >= 0);
        if (isEnoughLeft) {
            this.piecesOfFruitLeft = piecesOfFruitLeft - numberOfPiecesToRemove;
        }
        return isEnoughLeft;
    }
}
