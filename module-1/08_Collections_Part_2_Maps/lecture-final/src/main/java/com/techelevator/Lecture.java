package com.techelevator;

import java.util.*;

public class Lecture {

	public static void main(String[] args)
	{
//		createMap();
		updateMap();

	}

	public static void createMap()
	{
		Scanner input = new Scanner(System.in);

		Map<String, Integer> supplies;
		supplies = new HashMap<>();

		supplies.put("scissors", 10);
		supplies.put("markers", 20);
		supplies.put("rulers", 5);
		supplies.put("brushes", 5);

		System.out.print("What do you want to search for? ");
		String searchWord = input.nextLine()
								 .toLowerCase()
								 .strip();

		int quantity = 0;

		// check to see if the key exists before
		// trying to get the value
//		if(supplies.containsKey(searchWord)) {
//			quantity = supplies.get(searchWord);
//		}
//
		quantity = supplies.getOrDefault(searchWord, 0);
		System.out.println("There are " + quantity + " " + searchWord + " available");





	}

	public static void updateMap()
	{

		Scanner input = new Scanner(System.in);

		Map<String, Integer> supplies;
//		supplies = new HashMap<>();
//		supplies = new LinkedHashMap<>();
		supplies = new TreeMap<>();

		supplies.put("scissors", 10);
		supplies.put("markers", 20);
		supplies.put("rulers", 5);
		supplies.put("brushes", 5);


		for (String key : supplies.keySet()) {
			int value = supplies.get(key);
			System.out.println(key + " : " + value);
		}

		System.out.println();
		System.out.print("What would you like to add? ");
		String name = input.nextLine().toLowerCase();
		System.out.print("How many? ");
		int count = Integer.parseInt(input.nextLine());

		// get the current value
		int currentCount = supplies.getOrDefault(name, 0);
		// add the new count
		currentCount += count;

		// add or replace the supply
		supplies.put(name, currentCount);

		System.out.println();

		for (Map.Entry<String, Integer> row : supplies.entrySet())
		{
			String key = row.getKey();
			int value = row.getValue();
			System.out.println(key + " : " + value);
		}
//
//		System.out.println();
//
//		for(int value : supplies.values())
//		{
//			System.out.println(value);
//		}


	}

}
