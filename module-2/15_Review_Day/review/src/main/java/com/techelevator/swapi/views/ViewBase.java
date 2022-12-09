package com.techelevator.swapi.views;
import java.util.Scanner;

// generic ViewBase take any type
public abstract class ViewBase<T> {

    public final Scanner scanner = new Scanner(System.in);

    private T value;

    public void setValue(T value){
        this.value = value;
    }

    public T getValue(){
        return value;
    }

    public abstract void display();

}
