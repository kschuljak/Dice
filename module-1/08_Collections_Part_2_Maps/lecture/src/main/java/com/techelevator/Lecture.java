package com.techelevator;

import java.util.*;

public class Lecture {

	public static void main(String[] args) {


		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();

		createMap();
		updateMap();


	}

	public static void createMap() {

		Scanner input = new Scanner(System.in);

		// have to use wrapper classes for primitive data types
		// because they have to be managed on the heap
		// hashmap is the most common type of map used
		Map<String, Integer> supplies;
		supplies = new HashMap<>();

		/*
		 for keys, case matters
		 "Scissors", "scissors", and "SCISSORS" are all unique keys
		*/
		supplies.put("scissors", 10);
		supplies.put("markers", 20);
		supplies.put("rulers", 5);
		supplies.put("brushes", 5);

		// supplies.get(0);  !!!DOES NOT WORK - map is an unordered list
		// instead, access value by using key:
		// supplies.get("Rulers");
		// !!! canNOT loop up key using value (because values do not have to be unique)

		System.out.print("What do you want to search for? ");

		// sanitize user input - convert to lower case and strip out leading/trailing spaces
		String searchWord = input.nextLine()
				.toLowerCase()
				.strip();

		// check to see if key exists before trying to get value
		int quantity = 0;
		if (supplies.containsKey(searchWord)) quantity = supplies.get(searchWord);

		/*
		alternatively, use getOrDefault() to set default
		quantity = supplies.getOrDefault(searchWord, 0);
		 */

		System.out.println("There are " + quantity + " " + searchWord + " available");
		System.out.println();

	}

	public static void updateMap() {

		Scanner input = new Scanner(System.in);

		Map<String, Integer> supplies;
		supplies = new HashMap<>();

		supplies.put("scissors", 10);
		supplies.put("markers", 20);
		supplies.put("rulers", 5);
		supplies.put("brushes", 5);

		System.out.println("Current Items ");
		for (Map.Entry<String, Integer> row : supplies.entrySet()) {
			System.out.println(row.getKey() + " : " + row.getValue());
		}

		System.out.println();
		System.out.print("What would you like to add? ");
		String supplyItem = input.nextLine()
				.toLowerCase()
				.strip();

		System.out.println();
		System.out.print("How many " + supplyItem + " would you like to add? ");
		String itemNumber = input.nextLine().strip();
		int itemNumberAsInt = Integer.parseInt(itemNumber);

		// get the current value
		int currentCount = supplies.getOrDefault(supplyItem, 0);
		//add the new count
		currentCount += itemNumberAsInt;

		supplies.put(supplyItem, currentCount);
		System.out.println();

		System.out.println("Updated Items ");
		for (Map.Entry<String, Integer> row : supplies.entrySet()) {
			System.out.println(row.getKey() + " : " + row.getValue());
		}

	}
}




//		// JavaScript (returns value for key "Markers")     supplies.Markers
//		// Java	      (returns value for key "Markers")		supplies.get("Markers")
//
//		// cannot use for loop because no index - maps are unordered
//		// order output in foreach loop is created by hash value
		// note: linked-hashmap keeps order that items are added to list (because linked list)
		// note: tree map does not create a hash, but instead sorts by key (but is much slower than hashmap)
//
//		// use foreach loop to get key
//		// then lookup value of key from map
//		for (String key : supplies.keySet()) {
//			System.out.println(key + " : " + supplies.get(key));
//		}
//
//		// or loop through by each line (key & value)
//		// more efficient than doing steps separately
//		// String key = row.getKey();  &&  int value = row.getValue();
//		for (Map.Entry<String, Integer> row : supplies.entrySet()) {
//			System.out.println(row.getKey() + " : " + row.getValue());
//		}
//
//		// to only get values (and not keys)
//		int totalNumberOfSupplies = 0;
//		for (int value : supplies.values()) {
//			totalNumberOfSupplies += value;
//		}
//		System.out.println("Total number of supply items: " + totalNumberOfSupplies);
//
//	}

//}

/*
A hash is a compressed numerical value
hashes are created by converting an input value via a hash function
hash values are of a fixed length

take in data block of fixed length
split input into as many data blocks necessary (often using padding)
the hash function is run as many times as there are data blocks
the output of the previous data block is fed into hash function
(input = previous hash + next data block)

---
map
(key --> value)		can get value from key
!(key <-- value)	!!! can NOT get key from value
 */
