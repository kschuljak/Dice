package com.techelevator;

import java.util.*;

public class Lecture {

	public static void main(String[] args) {
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");

		List<String> heroes = new ArrayList<>();
		List<Integer> numbers = new LinkedList<>();


		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");

		heroes.add("Thor");
		heroes.add("Hulk");
		heroes.add("Black Widow");
		heroes.add(0,"Captain America");
		heroes.add("Captain Marvel");


		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");

		heroes.add("Thor");
		heroes.add("Thor");
		heroes.add("Thor");

		for (int i = 0; i < heroes.size(); i++)
		{
			String hero = heroes.get(i);
			System.out.println(hero);
		}


		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");
		System.out.println();

		heroes.add(5, "Iron Man");
		for(String hero : heroes)
		{
			System.out.println(hero);
		}

		System.out.println();
		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");
		System.out.println();

		heroes.remove("Thor");
		for(String hero : heroes)
		{
			System.out.println(hero);
		}

		System.out.println();
		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");
		System.out.println();

		while(heroes.contains("Thor"))
		{
			heroes.remove("Thor");
		}

		for(String hero : heroes)
		{
			System.out.println(hero);
		}

		System.out.println();
		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");
		System.out.println();

		System.out.println(heroes.indexOf("Black Widow"));
		Collections.sort(heroes);
		Collections.reverse(heroes);

		for(String hero : heroes)
		{
			System.out.println(hero);
		}

		System.out.println();
		System.out.println("shuffle");
		System.out.println();

		Collections.shuffle(heroes);

		for(String hero : heroes)
		{
			System.out.println(hero);
		}


		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");

		String[] names = new String[heroes.size()];
		for (int i = 0; i < heroes.size(); i++) {
			 names[i] = heroes.get(i);
		}

		String[] names2 = heroes.toArray(new String[heroes.size()]);


		System.out.println();
		System.out.println("####################");
		System.out.println("Stack");
		System.out.println("####################");
		System.out.println();

		Stack<String> tempNames = new Stack<>();

		// 1 push all names onto the stack
		for (String hero : heroes) {
			tempNames.push(hero);
		}

		List<String> reversedList = new ArrayList<>();

		// pop names off the stack and add them to the list
		while (!tempNames.empty())
		{
			String name = tempNames.pop();
			reversedList.add(name);
		}

		for (String name : reversedList) {
			System.out.println(name);
		}

		System.out.println();
		System.out.println("####################");
		System.out.println("Lists can be reversed too");
		System.out.println("####################");
		System.out.println();

		Queue<String> dcHeroes = new LinkedList<>();

		dcHeroes.offer("Superman");
		dcHeroes.offer("Wonder Woman");
		dcHeroes.offer("Batman");
		dcHeroes.offer("The Joker");

		while(dcHeroes.size() > 0)
		{
			String hero = dcHeroes.poll();
			System.out.println(hero);
//			if(hero.equalsIgnoreCase("superman"))
//			{
//				dcHeroes.offer(hero);
//			}
		}
//
//
//		System.out.println("####################");
//		System.out.println("       FOREACH");
//		System.out.println("####################");
//		System.out.println();


	}
}
