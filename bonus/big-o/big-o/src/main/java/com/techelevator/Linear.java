package com.techelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Linear
{
    // O(n)
    public static void main(String[] args) throws InterruptedException
    {

        int size = 11;

        Integer[] numbers = getNumbers(size);

        long start = System.currentTimeMillis();
        int value = sum(numbers);
        long end = System.currentTimeMillis();

        double seconds = (end - start)/1000.0;
        System.out.println(seconds + " seconds");
        System.out.println();

        System.out.println(value);

        System.out.println();
        System.out.println(seconds + " seconds");

    }

    private static int sum(Integer[] numbers) throws InterruptedException
    {
        int sum = 0;

        for (Integer number : numbers)
        {
            sum += number;
            Thread.sleep(10);
        }

        return sum;
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
