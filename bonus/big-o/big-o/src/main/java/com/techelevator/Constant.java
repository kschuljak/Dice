package com.techelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Constant
{

    // O(1)
    public static void main(String[] args) throws InterruptedException
    {

        int size = 10000;
        int index = size / 2;

        Integer[] numbers = getNumbers(size);

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

    private static int getValue(Integer[] numbers, int index) throws InterruptedException
    {
        int number = numbers[index];
        Thread.sleep(10);

        return number;
    }


    private static Integer[] getNumbers(int size)
    {
        List<Integer> numbers = new ArrayList<>(size);

        for (int i = 0; i < size; i++)
        {
            numbers.add(i + 1);
        }

        Collections.shuffle(numbers);

        return numbers.toArray(new Integer[0]);
    }
}
