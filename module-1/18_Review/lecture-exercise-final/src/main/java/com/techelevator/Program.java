package com.techelevator;

import com.techelevator.application.Store;

public class Program 
{
	// The purpose of this class is just to launch the store application
	// 		static void main is the only method in this class
	public static void main(String[] args) 
	{
		Store store = new Store();
		store.run();
	}
}
