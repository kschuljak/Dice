package com.techelevator;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Exercises {

	/*
	 * Given the name of an animal, return the name of a group of that animal
	 * (e.g. "Elephant" -> "Herd", "Rhino" -> "Crash").
	 *
	 * The animal name should be case insensitive so "elephant", "Elephant", and
	 * "ELEPHANT" should all return "Herd".
	 *
	 * If the name of the animal is not found, null, or empty, return "unknown".
	 *
	 * Rhino -> Crash
	 * Giraffe -> Tower
	 * Elephant -> Herd
	 * Lion -> Pride
	 * Crow -> Murder
	 * Pigeon -> Kit
	 * Flamingo -> Pat
	 * Deer -> Herd
	 * Dog -> Pack
	 * Crocodile -> Float
	 *
	 * animalGroupName("giraffe") → "Tower"
	 * animalGroupName("") -> "unknown"
	 * animalGroupName("walrus") -> "unknown"
	 * animalGroupName("Rhino") -> "Crash"
	 * animalGroupName("rhino") -> "Crash"
	 * animalGroupName("elephants") -> "unknown"
	 *
	 */
	public String animalGroupName(String animalName) {

		// create map
		Map<String, String> animals = new HashMap<>();
		animals.put("rhino", "Crash");
		animals.put("giraffe", "Tower");
		animals.put("elephant", "Herd");
		animals.put("lion", "Pride");
		animals.put("crow", "Murder");
		animals.put("pigeon", "Kit");
		animals.put("flamingo", "Pat");
		animals.put("deer", "Herd");
		animals.put("dog", "Pack");
		animals.put("crocodile", "Float");

		// error handling if null
		if (animalName == null) return "unknown";

		// format input
		String searchKey = animalName.toLowerCase().strip();

		// return value of key or default
		return animals.getOrDefault(searchKey, "unknown");

	}

	/*
	 * Given a String item number (a.k.a. SKU), return the discount percentage if the item is on sale.
	 * If the item is not on sale, return 0.00.
	 *
	 * If the item number is empty or null, return 0.00.
	 *
	 * "KITCHEN4001" -> 0.20
	 * "GARAGE1070" -> 0.15
	 * "LIVINGROOM"	-> 0.10
	 * "KITCHEN6073" -> 0.40
	 * "BEDROOM3434" -> 0.60
	 * "BATH0073" -> 0.15
	 *
	 * The item number should be case insensitive so "kitchen4001", "Kitchen4001", and "KITCHEN4001"
	 * should all return 0.20.
	 *
	 * isItOnSale("kitchen4001") → 0.20
	 * isItOnSale("") → 0.00
	 * isItOnSale("GARAGE1070") → 0.15
	 * isItOnSale("dungeon9999") → 0.00
	 *
	 */
	public double isItOnSale(String itemNumber) {

		// create map
		Map<String, Double> saleList = new HashMap<>();
		saleList.put("KITCHEN4001", 0.20);
		saleList.put("GARAGE1070", 0.15);
		saleList.put("LIVINGROOM", 0.10);
		saleList.put("KITCHEN6073", 0.40);
		saleList.put("BEDROOM3434", 0.60);
		saleList.put("BATH0073", 0.15);

		// error handling if null
		if (itemNumber == null) return 0.00;

		// format input
		String itemNumberFromInput = itemNumber.toUpperCase().strip();

		// return value of key or default
		return saleList.getOrDefault(itemNumberFromInput, 0.00);
	}

	/*
	 * Modify and return the given Map as follows: if "Peter" has more than 0 money, transfer half of it to "Paul",
	 * but only if Paul has less than $10s.
	 *
	 * Note, monetary amounts are specified in cents: penny=1, nickel=5, ... $1=100, ... $10=1000, ...
	 *
	 * robPeterToPayPaul({"Peter": 2000, "Paul": 99}) → {"Peter": 1000, "Paul": 1099}
	 * robPeterToPayPaul({"Peter": 2000, "Paul": 30000}) → {"Peter": 2000, "Paul": 30000}
	 *
	 */
	public Map<String, Integer> robPeterToPayPaul(Map<String, Integer> peterPaul) {

		Integer petersMoney = peterPaul.get("Peter");
		Integer paulsMoney = peterPaul.get("Paul");
		if (petersMoney > 0 && paulsMoney < 1000) {
			int halfPetersMoney = petersMoney / 2;
			petersMoney -= halfPetersMoney;
			paulsMoney += halfPetersMoney;
			peterPaul.replace("Peter", petersMoney);
			peterPaul.replace("Paul", paulsMoney);
		}
		return peterPaul;

	}

	/*
	 * Modify and return the given Map as follows: if "Peter" has $50 or more, AND "Paul" has $100 or more,
	 * then create a new "PeterPaulPartnership" worth a combined contribution of a quarter of each partner's
	 * current worth.
	 *
	 * peterPaulPartnership({"Peter": 50000, "Paul": 100000}) → {"Peter": 37500, "Paul": 75000, "PeterPaulPartnership": 37500}
	 * peterPaulPartnership({"Peter": 3333, "Paul": 1234567890}) → {"Peter": 3333, "Paul": 1234567890}
	 *
	 */
	public Map<String, Integer> peterPaulPartnership(Map<String, Integer> peterPaul) {

		Integer petersMoney = peterPaul.get("Peter");
		Integer paulsMoney = peterPaul.get("Paul");

		if (petersMoney >= 5000 && paulsMoney >= 10000 ) {
			Integer petersContribution = petersMoney / 4;
			Integer paulsContribution = paulsMoney / 4;
			peterPaul.put("PeterPaulPartnership", petersContribution + paulsContribution);
			peterPaul.replace("Peter", petersMoney - petersContribution);
			peterPaul.replace("Paul", paulsMoney - paulsContribution);
		}
		return peterPaul;
	}

	/*
	 * Given an array of non-empty Strings, return a Map<String, String> where for every different String in the array,
	 * there is a key of its first character with the value of its last character.
	 *
	 * beginningAndEnding(["code", "bug"]) → {"b": "g", "c": "e"}
	 * beginningAndEnding(["man", "moon", "main"]) → {"m": "n"}
	 * beginningAndEnding(["muddy", "good", "moat", "good", "night"]) → {"g": "d", "m": "t", "n": "t"}
	 */
	public Map<String, String> beginningAndEnding(String[] words) {

		// create map to hold result values
		Map<String, String> firstAndLast = new HashMap<>();

		// create map to hold unique boolean - if duplicate do not add to result values
		Map<String, Boolean>  unique = new HashMap<>();

		// iterate through string, check if unique, then add to result values
		for (String word : words) {
			if (!(unique.containsKey(word))) {
				unique.put(word, true);
				String first = String.valueOf(word.charAt(0));
				String last = String.valueOf(word.charAt(word.length() - 1));
				firstAndLast.put(first, last);
			}
		}

		return firstAndLast;
	}

	/*
	 * Given an array of Strings, return a Map<String, Integer> with a key for each different String,
	 * with the value the number of times that String appears in the array.
	 *
	 * ** A CLASSIC **
	 *
	 * wordCount(["ba", "ba", "black", "sheep"]) → {"ba" : 2, "black": 1, "sheep": 1 }
	 * wordCount(["a", "b", "a", "c", "b"]) → {"b": 2, "c": 1, "a": 2}
	 * wordCount([]) → {}
	 * wordCount(["c", "b", "a"]) → {"b": 1, "c": 1, "a": 1}
	 *
	 */
	public Map<String, Integer> wordCount(String[] words) {

		Map<String, Integer> numberOfTimesSeen = new HashMap<>();
		for (String word : words) {
			if (numberOfTimesSeen.containsKey(word)) {
				int value = numberOfTimesSeen.get(word);
				value++;
				numberOfTimesSeen.replace(word, value);
			} else {
				numberOfTimesSeen.put(word, 1);
			}
		}
		return numberOfTimesSeen;
	}

	/*
	 * Given an array of int values, return a Map<Integer, Integer> with a key for each int, with the value the
	 * number of times that int appears in the array.
	 *
	 * ** The lesser known cousin of the classic wordCount **
	 *
	 * intCount([1, 99, 63, 1, 55, 77, 63, 99, 63, 44]) → {1: 2, 44: 1, 55: 1, 63: 3, 77: 1, 99:2}
	 * intCount([107, 33, 107, 33, 33, 33, 106, 107]) → {33: 4, 106: 1, 107: 3}
	 * intCount([]) → {}
	 *
	 */
	public Map<Integer, Integer> integerCount(int[] ints) {

		Map<Integer, Integer> numberOfTimesSeen = new HashMap<>();
		for (int number : ints) {
			if (numberOfTimesSeen.containsKey(number)) {
				int value = numberOfTimesSeen.get(number);
				value++;
				numberOfTimesSeen.replace(number, value);
			} else {
				numberOfTimesSeen.put(number, 1);
			}
		}
		return numberOfTimesSeen;
	}

	/*
	 * Given an array of Strings, return a Map<String, Boolean> where each different String is a key and value
	 * is true only if that String appears 2 or more times in the array.
	 *
	 * wordMultiple(["a", "b", "a", "c", "b"]) → {"b": true, "c": false, "a": true}
	 * wordMultiple(["c", "b", "a"]) → {"b": false, "c": false, "a": false}
	 * wordMultiple(["c", "c", "c", "c"]) → {"c": true}
	 *
	 */
	public Map<String, Boolean> wordMultiple(String[] words) {

		Map<String, Boolean> areMultiple = new HashMap<>();
		for (String word : words) {
			if (areMultiple.containsKey(word)) {
				areMultiple.replace(word, true);
			} else {
				areMultiple.put(word, false);
			}
		}
		return areMultiple;

	}

	/*
	 * Given two Maps, Map<String, Integer>, merge the two into a new Map, Map<String, Integer> where keys in Map2,
	 * and their int values, are added to the int values of matching keys in Map1. Return the new Map.
	 *
	 * Unmatched keys and their int values in Map2 are simply added to Map1.
	 *
	 * consolidateInventory({"SKU1": 100, "SKU2": 53, "SKU3": 44} {"SKU2":11, "SKU4": 5})
	 * 	 → {"SKU1": 100, "SKU2": 64, "SKU3": 44, "SKU4": 5}
	 *
	 */
	public Map<String, Integer> consolidateInventory(Map<String, Integer> mainWarehouse,
			Map<String, Integer> remoteWarehouse) {

		// cycle through main map
		// get (key, value) pair for each entry
		// if key in alt map, add values and replace total in main map
		for (Map.Entry<String, Integer> row : mainWarehouse.entrySet()) {
			String mainKey = row.getKey();
			Integer mainValue = row.getValue();
			if (remoteWarehouse.containsKey(mainKey)) {
				mainValue += remoteWarehouse.get(mainKey);
				mainWarehouse.replace(mainKey, mainValue);
			}
		}

		// cycle through alt map
		// get (key, value) pair for each entry
		// if key does not appear in main map
		// add (key, value) to main map
		for (Map.Entry<String, Integer> row : remoteWarehouse.entrySet()) {
			String remoteKey = row.getKey();
			Integer remoteValue = row.getValue();
			if (!(mainWarehouse.containsKey(remoteKey))) {
				mainWarehouse.put(remoteKey, remoteValue);
			}
		}
		return mainWarehouse;
	}

	/*
	 * Just when you thought it was safe to get back in the water --- last2Revisited!!!!
	 *
	 * Given an array of Strings, for each String, the count of the number of times that a subString length 2 appears
	 * in the String and also as the last 2 chars of the String, so "hixxxhi" yields 1.
	 *
	 * We don't count the end subString, but the subString may overlap a prior position by one.  For instance, "xxxx"
	 * has a count of 2, one pair at position 0, and the second at position 1. The third pair at position 2 is the
	 * end subString, which we don't count.
	 *
	 * Return Map<String, Integer>, where the key is String from the array, and its last2 count.
	 *
	 * last2Revisited(["hixxhi", "xaxxaxaxx", "axxxaaxx"]) → {"hixxhi": 1, "xaxxaxaxx": 1, "axxxaaxx": 2}
	 *
	 */
	public Map<String, Integer> last2Revisited(String[] words) {

		Map<String, Integer> lastTwo = new HashMap<>();

		for (String word : words) {
			int timesSeen = 0;
			String substringLastTwo = word.substring(word.length() - 2);
			for (int i = 0; i < word.length() - 2; i++) {
				if (word.substring(i, i + 2).equals(substringLastTwo)) {
					timesSeen++;
				}
			}
			lastTwo.put(word, timesSeen);
		}
		return lastTwo;
	}

}
