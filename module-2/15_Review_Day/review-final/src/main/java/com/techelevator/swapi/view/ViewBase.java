package com.techelevator.swapi.view;

import java.util.Scanner;

public abstract class ViewBase<T>
{
    public final Scanner scanner = new Scanner(System.in);

    private T value;

    public void setValue(T value)
    {
        this.value = value;
    }

    public T getValue()
    {
        return value;
    }

    public abstract void display();

    public String getValue(String message)
    {
        System.out.println();
        System.out.print(message + " ");
        String value = scanner.nextLine();

        return value;
    }

    public int getIntValue(String message)
    {
        String value = getValue(message);
        return Integer.parseInt(value);
    }

    public void displayHeader(String header)
    {
        System.out.println();
        System.out.println("****************************************");
        System.out.println(header);
        System.out.println("****************************************");
        System.out.println();
    }
}
