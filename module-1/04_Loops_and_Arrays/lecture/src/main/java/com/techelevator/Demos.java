package com.techelevator;

public class Demos 
{
    public static void main(String[] args) {

        int[] numbers = {4, 7, 13, 81, 37};

        System.out.println("SUM");
        System.out.println(Sum(numbers));
        System.out.println();

        System.out.println("SUM OF EVENS");
        System.out.println(SumEvens(numbers));
        System.out.println();

        System.out.println("SUM OF ODDS");
        System.out.println(SumOdds(numbers));
        System.out.println();

        System.out.println("MINIMUM");
        System.out.println(Minimum(numbers));
        System.out.println();

        System.out.println("MAXIMUM");
        System.out.println(Maximum(numbers));
        System.out.println();

        System.out.println("MEAN");
        System.out.println(Mean(numbers));
        System.out.println();

        System.out.println("MEDIAN");
        System.out.println(Median(numbers));
        System.out.println();


    }


    public static int Sum(int[] numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        return sum;
    }

    public static int SumEvens(int[] numbers) {
        int sumOfEvens = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                sumOfEvens += numbers[i];
            }
        }
        return sumOfEvens;
    }

    public static int SumOdds(int[] numbers) {
        int sumOfOdds = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 1) {
                sumOfOdds += numbers[i];
            }
        }
        return sumOfOdds;
    }


    public static int Minimum(int[] numbers) {
        int minimum = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < minimum) {
                minimum = numbers[i];
            }
        }
        return minimum;
    }

    public static int Maximum(int[] numbers) {
        int maximum = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > maximum) {
                maximum = numbers[i];
            }
        }
        return maximum;
    }

    // mean is the average
    public static int Mean(int[] numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        return (sum/numbers.length);
    }

    // median is the middle if there is an odd number of elements
    // ex: 1, 4, **7**, 10, 12
    // ex: median = 7
    // it is the average of the middle 2 if there is an even number of elements
    // ex: 1, 4, **7**, **9**, 10, 12
    // ex: median = (7 + 9) / 2
    public static int Median(int[] numbers) {
        boolean isEven = (numbers.length % 2 == 0);
        int middle = numbers.length / 2;
        if (isEven) {
            int sumOfMiddles = numbers[middle - 1] + numbers[middle];
            return sumOfMiddles/2;
        } else {
            return numbers[middle];
        }
    }
   
}
