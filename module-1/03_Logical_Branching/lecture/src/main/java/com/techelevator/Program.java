package com.techelevator;

// Java compiles whole program and stores in memory before running
// so, you don't have to define your functions before you use them
// (aka - it's not read top to bottom)
public class Program {

    // calling side / main program
    public static void main(String[] args) {

        int x = 5;
        int y = 6;
        // user that needs some work done
        // call function 'add' with parameters 'x' & 'y'
        int answer = add(x, y);
        display(x, y, answer);

        saveToDatabase("Kat", 30);

    }

    // receiving side / side that is called / functions called in main program
    public static int add(int a, int b){
        int answer = a + b;
        return answer;
    }

    public static void saveToDatabase(String name, int age){
        // perform some logic to save these values to a database
    }

    public static void display(int a, int b, int answer) {
        // displays 'a + b = answer'
        System.out.println(a + " + " + b + " = " + answer);
    }

}
