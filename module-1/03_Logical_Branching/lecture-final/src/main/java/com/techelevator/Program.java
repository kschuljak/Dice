package com.techelevator;

public class Program {


    public static int add(int a, int b)
    {
        int answer = a + b;

        return answer;
    }

    public static void display(int a, int b, int answer)
    {
        System.out.println(a + " + " + b + " = " + answer);
    }

    public static void main(String[] args) {

        int x = 5;
        int y = 6;
        // user that needs some work done
        int answer = add(x, y);
        display(x, y, answer);

        saveToDatabase("Gregor", 47);

    }

    public static void saveToDatabase(String name, int age)
    {
        // perform some logic to save these values to a db
    }

}
