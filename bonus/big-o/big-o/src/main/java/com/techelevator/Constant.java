package com.techelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// accessing array element by index
public class Constant
{

    // O(1)
    public static void main(String[] args) throws InterruptedException
    {

        int size = 10000;
        int index = size / 2;

        // Integer[] numbers = getNumbers(size);
        List<Integer> numbers = new ArrayList<>();

        long start = System.currentTimeMillis();
        int value = getValue(numbers, index);
        long end = System.currentTimeMillis();

        double seconds = (end - start)/1000.0;
        System.out.println(seconds + " seconds");
        System.out.println();

        System.out.println(value);

        System.out.println();
        System.out.println(seconds + " seconds");

    }

    // simulate processing time using Thread.sleep(10 milliseconds)
    // private static int getValue(Integer[] numbers, int index) throws InterruptedException
    private static int getValue(List<Integer> numbers, int index) throws InterruptedException
    {
        // int number = numbers[index];
        int number = numbers.get(index);
        Thread.sleep(10);

        return number;
    }


    // private static Integer[] getNumbers(int size)
    private static List<Integer> getNumbers(int size)
    {
        List<Integer> numbers = new ArrayList<>(size);

        for (int i = 0; i < size; i++)
        {
            numbers.add(i + 1);
        }

        Collections.shuffle(numbers);

        // return numbers.toArray(new Integer[0]);
        return numbers;
    }
}
