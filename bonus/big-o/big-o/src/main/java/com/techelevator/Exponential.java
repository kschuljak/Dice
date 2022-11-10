package com.techelevator;


public class Exponential
{
    // O(2^n)
    public static void main(String[] args) throws InterruptedException
    {
        long number = 11;

        long start = System.currentTimeMillis();
        long fib = fibonacci(number);
        long end = System.currentTimeMillis();

        double seconds = (end - start)/1000.0;

        System.out.println();
        System.out.println(seconds + " seconds");
        System.out.println("Fibonacci Exponential: " + fib);
        System.out.println();

        start = System.currentTimeMillis();
        fib = fibonacciLinear(number);
        end = System.currentTimeMillis();

        seconds = (end - start)/1000.0;

        System.out.println();
        System.out.println(seconds + " seconds");
        System.out.println("Fibonacci Linear: " + fib);
        System.out.println();

        start = System.currentTimeMillis();
        fib = fibonacciConstant(number);
        end = System.currentTimeMillis();

        seconds = (end - start)/1000.0;

        System.out.println();
        System.out.println(seconds + " seconds");
        System.out.println("Fibonacci Constant: " + fib);
        System.out.println();

    }

    // calculate fibonacci sequence using recursion
    // each calculation to get previous 2 numbers calls Thread.sleep 3 times
    private static long fibonacci(long number) throws InterruptedException
    {
        Thread.sleep(10);
        if(number <= 1)
        {
            return number;
        }

        return fibonacci(number - 2) + fibonacci(number - 1);
    }

    // calculate fibonacci sequence using iteration
    private static long fibonacciLinear(long number) throws InterruptedException
    {
        int prev = 0;
        int current = 1;
        int next = 1;
        for (int i = 1; i < number; i++)
        {
            next = prev + current;
            prev = current;
            current = next;
            Thread.sleep(10);
        }

        return next;
    }

    // calculate fibonacci sequence using Math & the golden ratio
    private static long fibonacciConstant(long number) throws InterruptedException
    {
        Thread.sleep(10);

        double golden = 1.618025751072961;
        double numerator =  Math.pow(golden, number) - Math.pow(1-golden, number);
        double denominator = Math.sqrt(5);
        double answer = numerator / denominator;

        return (long)answer + 1;
    }
}
