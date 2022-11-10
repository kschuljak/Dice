package com.techelevator.demos;

import java.util.ArrayList;
import java.util.List;

public class MergeLanes
{

    /*
     Given two lists of Integers, interleave them beginning
     with the first element in the first list followed
     by the first element of the second. Continue interleaving
     the elements until all elements have been interwoven.
     Return the new list. If the lists are of unequal lengths,
     simply attach the remaining elements of the longer
     list to the new list before returning it.

     merge( [1, 2, 3], [4, 5, 6] )  ->  [1, 4, 2, 5, 3, 6]
     merge( [1, 2], [4, 5, 6] )  ->  [1, 4, 2, 5, 6]
     merge( [1, 2, 3], [4] )  ->  [1, 4, 2, 3]
     */
    public List<Integer> merge(List<Integer> listOne, List<Integer> listTwo)
    {
        List<Integer> list = new ArrayList<>();
        int maxSize = Math.max(listOne.size(), listTwo.size());

        for (int i = 0; i < maxSize ; i++)
        {
            if(i < listOne.size()) list.add(listOne.get(i));
            if(i < listTwo.size()) list.add(listTwo.get(i));
        }

        return list;
    }
}
