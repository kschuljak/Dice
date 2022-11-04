package com.techelevator;

import java.util.*;

public class Review
{
    public static void main(String[] args)
    {
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
        cities.add("Oakland,Ninja");
        cities.add("Los Angeles,Jonathan");
        cities.add("Los Angeles,Vanessa");
        cities.add("Los Angeles,Joe");
        cities.add("Los Angeles,Sam");
        cities.add("Los Angeles,Big Joe");
        cities.add("Los Angeles,Christina");
        cities.add("Los Angeles,Cat");
        cities.add("Los Angeles,Hong");
        cities.add("Los Angeles,Veronica");
        cities.add("Los Angeles,Hailey");
        cities.add("The High Desert,Austin");
        cities.add("The Desert,Gregor");
        cities.add("Columbus,Gary");
        cities.add("New York,Hannah");

//        Set<String> uniqueCities = new HashSet<>(cities);
//
//        for (String city : uniqueCities)
//        {
//            System.out.println(city);
//        }

        // create all the groupings
        Map<String,List<String>>  cityGroups = new HashMap<>();
        for (String location : cities)
        {
            String[] city = location.split(",");
            List<String> people;

            if(!cityGroups.containsKey(city[0]))
            {
                people = new ArrayList<>();
            }
            else
            {
                people = cityGroups.get(city[0]);
            }

            people.add(city[1]);

            cityGroups.put(city[0], people);

        }

        for (Map.Entry<String, List<String>> row : cityGroups.entrySet())
        {
            String city = row.getKey();
            List<String> people = row.getValue();

            System.out.println(city);
            System.out.println("---------------");
            for (String person : people)
            {
                System.out.println("  " + person);
            }
            System.out.println();

        }

    }
}
