package com.techelevator;

import java.util.*;

public class SetsReview {

    public static void main(String[] args) {

        // hash set - information sorted by hashed value
        // tree set - information sorted by sort order (numeric, alphabetical, etc)
        // linked hash set - information sorted by order added

        /*
        Set<String> food = new HashSet<>();
        food.add("Milk Chocolate");
        food.add("Ice Cream");
        food.add("Milk Chocolate");  //!!! ignored - sets must have unique values
        */


        List<String> cities = new ArrayList<>();

        cities.add("Seattle,Quinn");
        cities.add("Seattle,Daniel");
        cities.add("Seattle,Rachel");
        cities.add("Seattle,Emma");
        cities.add("Seattle,Storm");
        cities.add("Seattle,Katherine");
        cities.add("San Francisco,Patricia");
        cities.add("San Francisco,Austin");
        cities.add("San Francisco,Kayla");
        cities.add("San Francisco,Ninja");
        cities.add("Los Angeles,Jonathan");
        cities.add("Los Angeles,Vanessa");
        cities.add("Los Angeles,Joe");
        cities.add("Los Angeles,Sam");
        cities.add("Los Angeles,Big Joe");
        cities.add("Los Angeles,Christina");
        cities.add("Los Angeles,Cart");
        cities.add("Los Angeles,Hong");
        cities.add("Los Angeles,Veronica");
        cities.add("Los Angeles,Hailey");
        cities.add("Columbus,Gary");
        cities.add("The Desert,Gregor");
        cities.add("The High Desert,Austin");
        cities.add("New York City,Hannah");

//        System.out.println("List: ");
//        for (String city: cities) {
//            System.out.println(city);
//        }

//        Set<String> uniqueCities = new HashSet<>(cities);
//
//        System.out.println("Set: ");
//        for (String city : uniqueCities) {
//            System.out.println(city);
//        }

        // create map of key = string, value = list of strings
        Map<String, List<String>> cityGroups = new HashMap<>();
        // iterate through map
        for (String location : cities) {

            String[] cityPersonSplit = location.split(",");
            List<String> people;

            // if key not in map
            if(!cityGroups.containsKey(cityPersonSplit[0])) {

                // create empty array list
                people = new ArrayList<>();

            } else { // if key is in map

                // get array list from value
                people = cityGroups.get(cityPersonSplit[0]);
            }

            // add value (person) to array list
            people.add(cityPersonSplit[1]);

            // put updated array list back in map (key = city, value = updated array list)
            cityGroups.put(cityPersonSplit[0], people);
        }
        // System.out.println(cityGroups);

        for (Map.Entry<String, List<String>> row : cityGroups.entrySet()) {
            String city = row.getKey();
            List<String> people = row.getValue();

            System.out.println(city);
            System.out.println("----------------");
            System.out.println(people);
            System.out.println();
        }

        for (Map.Entry<String, List<String>> row : cityGroups.entrySet()) {
            String city = row.getKey();
            List<String> people = row.getValue();

            System.out.println("----------------");
            System.out.println(city);
            System.out.println("----------------");
            for (String person : people) {
                System.out.println(" " + person);
            }
            System.out.println();
        }
    }
}
