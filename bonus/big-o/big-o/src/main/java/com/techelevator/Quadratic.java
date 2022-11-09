package com.techelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Quadratic
{
    // O(n^2)
    public static void main(String[] args) throws InterruptedException
    {

        int size = 20;

        Integer[] numbers = getNumbers(size);

        long start = System.currentTimeMillis();
        List<String> list = spread(numbers);
        long end = System.currentTimeMillis();

        double seconds = (end - start)/1000.0;
        System.out.println(seconds + " seconds");
        System.out.println();

        for (String value : list)
        {
            System.out.println(value);
        }

        System.out.println();
        System.out.println(seconds + " seconds");

    }

    private static List<String> spread(Integer[] numbers) throws InterruptedException
    {
        List<String> values = new ArrayList<>(numbers.length * numbers.length);

        for (Integer num1 : numbers)
        {
            for (Integer num2 : numbers)
            {
                values.add(num1 + " : " + num2);
                Thread.sleep(10);
            }
        }

        return values;
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
