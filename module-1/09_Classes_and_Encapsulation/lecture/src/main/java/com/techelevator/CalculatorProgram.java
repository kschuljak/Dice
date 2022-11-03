package com.techelevator;

import com.techelevator.models.Calculator;

public class CalculatorProgram {

    public static void main(String[] args) {

        double one = 12.5;
        double two = 3.25;

        // utility classes don't need instances
        double answer = Calculator.add(one, two);

        System.out.println(Calculator.add(one, two));
        System.out.println(Calculator.subtract(one, two));
        System.out.println(Calculator.multiply(one, two));
        System.out.println(Calculator.divide(one, two));

    }

}
