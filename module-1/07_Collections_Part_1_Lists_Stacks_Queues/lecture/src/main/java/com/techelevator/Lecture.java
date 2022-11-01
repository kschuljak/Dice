package com.techelevator;

import java.util.*;

public class Lecture {

	public static void main(String[] args) {
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");

		// ArrayList & LinkedList are two most common types of lists
		List<String> heroes = new ArrayList<>();
		List<Integer> numbers = new LinkedList<>();

		List<String> avengers;
		avengers = new ArrayList<>();

		// if you do not declare size of list, default is size is 4
		// every time list grows past allocated size, size will double
		// ex: 4 -> 8 -> 16 -> 32 -> etc
		// so, best practice is to declare size if known, to prevent repetitive growth
		// every time list grows, new memory needs to be allocated / re-allocated
		// because linked lists are (value + pointer), items can be spread throughout memory
		// thus, linked lists are very useful for dynamic lists
		// however, you have to iterate through each item to access an item at a specific index
		// manipulation of elements = much faster in a linked list
		// retrieval of data = much faster in an array list


		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");

		heroes.add("Thor");
		heroes.add("Spider-Man");
		heroes.add("Black Widow");
		heroes.add(1, "Captain America");
		heroes.add("Captain Marvel");
		heroes.add("Hulk");
		// actual size of list 'behind the scenes' is hidden in Java
		// you only see how many elements are in the list


		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");

		heroes.add("Thor");
		heroes.add("Thor");
		heroes.add("Thor");

		// we don't have access to the array behind the scenes
		// so instead of using an index, use .get()
		for (int i = 0; i < heroes.size(); i++) {
			String hero = heroes.get(i);
			System.out.println(hero);
		}
		System.out.println();
		/*
		Prints:
		 Thor
		 Captain America
		 Spider-Man
		 Black Widow
		 Captain Marvel
		 Hulk
		 Thor
		 Thor
		 Thor
		 */

		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");

		heroes.add(5, "Iron Man");
		for(String hero : heroes) {
			System.out.println(hero);
		}
		System.out.println();
		/*
		Prints:
		 Thor
		 Captain America
		 Spider-Man
		 Black Widow
		 Captain Marvel
		 Iron Man <--- added to middle of list
		 Hulk
		 Thor
		 Thor
		 Thor
		 */

		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");

		heroes.remove(8);
		for(String hero : heroes) {
			System.out.println(hero);
		}
		System.out.println();
		/*
		Prints:
		 Thor
		 Captain America
		 Spider-Man
		 Black Widow
		 Captain Marvel
		 Iron Man
		 Hulk
		 Thor
		 Thor
		 */

		heroes.remove("Thor");
		for(String hero : heroes) {
			System.out.println(hero);
		}
		/*
		Prints:
		 Captain America
		 Spider-Man
		 Black Widow
		 Captain Marvel
		 Iron Man
		 Hulk
		 Thor
		 Thor
		-- first instance of "Thor" is removed --
		 */

		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");

		if (heroes.contains("Thor")) System.out.println("Thor is in the list");
		// prints: Thor is in the list

		while(heroes.contains("Thor")){
			heroes.remove("Thor");
		}
		for(String hero : heroes) {
			System.out.println(hero);
		}
		/*
		Prints:
		 Captain America
		 Spider-Man
		 Black Widow
		 Captain Marvel
		 Iron Man
		 Hulk
		-- all instances of "Thor" are removed --
		 */

		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");

		System.out.println(heroes.indexOf("Black Widow"));  // 2
		Collections.reverse(heroes);

		for(String hero : heroes) System.out.println(hero);
		/*
		Prints:
		 Hulk
		 Iron Man
		 Captain Marvel
		 Black Widow
		 Spider-Man
		 Captain America
		*/


		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");

		String[] names = new String[heroes.size()];
		for (int i = 0; i < heroes.size(); i++) {
			names[i] = heroes.get(i);
		}

		String[] names2 = heroes.toArray(new String[heroes.size()]);
		String[] names3 = heroes.toArray(new String[0]);



		System.out.println("####################");
		System.out.println("Lists can be sorted");
		System.out.println("####################");

		Collections.sort(heroes);
		for (String hero: heroes) System.out.println(hero);
		System.out.println();
		/*
		Prints:
		 Black Widow
		 Captain America
		 Captain Marvel
		 Hulk
		 Iron Man
		 Spider-Man
		 */

		System.out.println("####################");
		System.out.println("Lists can be reversed too");
		System.out.println("####################");

		Collections.reverse(heroes);
		for (String hero : heroes) System.out.println(hero);
		System.out.println();
		/*
		Prints:
		 Spider-Man
		 Iron Man
		 Hulk
		 Captain Marvel
		 Captain America
		 Black Widow
		 */

		Collections.shuffle(heroes);

		for (String hero : heroes) System.out.println(hero);
		System.out.println();
		/*
		Prints:
		 Black Widow
		 Captain Marvel
		 Hulk
		 Spider-Man
		 Captain America
		 Iron Man
		 */


		System.out.println("####################");
		System.out.println(" Stack ");
		System.out.println("####################");
		System.out.println();

		Stack<String> tempNames = new Stack<>();
		for (String hero : heroes) {
			tempNames.push(hero);
		}
		System.out.println(tempNames);
		// Prints: [Black Widow, Iron Man, Spider-Man, Captain Marvel, Hulk, Captain America]

		List<String> reversedList = new ArrayList<>();
		// pop names off stack and add to list
		while (!tempNames.empty()) {
			String name = tempNames.pop();
			reversedList.add(name);
		}

		System.out.println("####################");
		System.out.println(" Queue ");
		System.out.println("####################");
		System.out.println();

		Queue<String> dcHeroes = new LinkedList<>();
		dcHeroes.offer("Batman");
		dcHeroes.offer("Robin");
		dcHeroes.offer("Superman");
		dcHeroes.offer("Wonder Woman");

		System.out.println(dcHeroes);        // [Batman, Robin, Superman, Wonder Woman]
		System.out.println(dcHeroes.poll()); // Batman
		System.out.println(dcHeroes);        // [Robin, Superman, Wonder Woman]

		/*
		(CAUTION - example has infinite loop!)
		while (dcHeroes.size() > 0) {
			String hero = dcHeroes.poll();
			System.out.println(hero);
			if(hero.equalsIgnoreCase("superman")) {
				dcHeroes.offer(hero);
			}
		}
		 */
	}
}
