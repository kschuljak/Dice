package com.techelevator;

import com.sun.source.tree.BreakTree;

import java.util.Arrays;

public class Demos
{
    public static void main(String[] args)
    {
        int[] numbers = { 13, 4, 7, 81, 37 };
        int[] numbers2 = { 4, 7, 90, 13, 81, 37 };

        int sum = sum(numbers);
        System.out.println(sum);

        int evenSum = sumEvens(numbers);
        System.out.println(evenSum);

        int median1 = median(numbers);
        System.out.println("Expect 13 - actual: " + median1);

        int median2 = median(numbers2);
        System.out.println("Expect 25 - actual: " + median2);

    }

    public static int sum(int[] numbers)
    {
        int result = 0;

        for (int i = 0; i < numbers.length; i++)
        {
            int number = numbers[i];
            result += number;
        }

        return result;
    }

    public static int sumEvens(int[] numbers)
    {
        int result = 0;

        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];

            if(number % 2 == 0)
            {
                result += number;
            }
        }

        return result;
    }

    public static int minimum(int[] numbers) {
        return 0;
    }

    public static int maximum(int[] numbers) {
        return 0;
    }

    // mean is the average
    public static int mean(int[] numbers) {
        return 0;
    }

    // median is the middle if there is an odd number
    // it is the average of the middle 2 if even
    // { 4, 7, 13, 37, 81 }
    //   0  1   2   3   4

    // { 4, 7, 13, 37, 81, 90 }
    //   0  1   2   3   4  5
    public static int median(int[] numbers) {
        Arrays.sort(numbers);

        boolean isOdd = numbers.length % 2 != 0;
        int middle = numbers.length / 2;


        if(isOdd) {
            return numbers[middle];
        }
        else {
            int sumOfMiddles = numbers[middle - 1] + numbers[middle];
            return sumOfMiddles / 2;
        }
    }
   
}
